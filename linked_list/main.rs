use std::io;

mod linked_list;
use crate::linked_list::LinkedList;

fn main() {
    let mut list = LinkedList::new();
    loop {
        println!("Enter a word: ");
        let mut word = String::new();
        io::stdin().read_line(&mut word).expect("Failed to read line");
        let word = word.trim().to_string();
        if word == "END" || word == "end" {
            break;
        }
        list.push(word);
    }

    list.traverse_and_print();
}
