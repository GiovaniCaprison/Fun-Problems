pub struct Node {
    value: String,
    next: Option<Box<Node>>,
}

impl Node {
    pub fn new(value: String) -> Node {
        Node { value, next: None }
    }
}

pub struct LinkedList {
    head: Option<Box<Node>>,
}

impl LinkedList {
    pub fn new() -> LinkedList {
        LinkedList { head: None }
    }

    pub fn push(&mut self, value: String) {
        let mut new_node = Box::new(Node::new(value));
        new_node.next = self.head.take();
        self.head = Some(new_node);
    }

    pub fn traverse_and_print(&self) {
        let mut current = &self.head;
        while let Some(ref node) = current {
            println!("{}", node.value);
            current = &node.next;
        }
    }
}
