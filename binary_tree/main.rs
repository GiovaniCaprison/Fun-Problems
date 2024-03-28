use std::cell::RefCell;
use std::rc::Rc;

#[derive(Debug)]
struct TreeNode {
    val: i32,
    left: Option<Rc<RefCell<TreeNode>>>,
    right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    fn new(val: i32) -> Self {
        TreeNode { val, left: None, right: None }
    }

    fn insert(&mut self, val: i32) {
        if val < self.val {
            match self.left {
                Some(ref mut node) => node.borrow_mut().insert(val),
                None => self.left = Some(Rc::new(RefCell::new(TreeNode::new(val)))),
            }
        } else {
            match self.right {
                Some(ref mut node) => node.borrow_mut().insert(val),
                None => self.right = Some(Rc::new(RefCell::new(TreeNode::new(val)))),
            }
        }
    }
}

fn tree_height(root: &Option<Rc<RefCell<TreeNode>>>) -> i32 {
    match root {
        Some(node) => 1 + std::cmp::max(tree_height(&node.borrow().left), tree_height(&node.borrow().right)),
        None => 0,
    }
}

fn main() {
    let mut numbers = String::new();
    println!("Enter numbers for the binary tree seperated with a comma: ");
    std::io::stdin().read_line(&mut numbers).unwrap();

    let nums: Vec<i32> = numbers
        .trim()
        .split(',')
        .map(|n| n.parse().expect("Not a valid number"))
        .collect();

    let tree = nums.iter().fold(None, |acc: Option<Rc<RefCell<TreeNode>>>, &val| {
        if let Some(root) = acc {
            root.borrow_mut().insert(val);
            Some(root)
        } else {
            Some(Rc::new(RefCell::new(TreeNode::new(val))))
        }
    });

    let height = tree_height(&tree);
    println!("The binary tree has {} levels", height);
}
