use std::collections::HashMap;
use std::hash::BuildHasherDefault;
use std::time::Instant;

use rand::random;
use rustc_hash::FxHasher;

type FxHashMap = HashMap<u64, u64, BuildHasherDefault<FxHasher>>;

fn collatz_steps_iterative(n: u64, cache: &mut FxHashMap) -> u64 {
    let mut current = n;
    let mut steps = 0;

    while current != 1 {
        if let Some(&cached_steps) = cache.get(&current) {
            steps += cached_steps;
            break;
        }
        else if current >= 9_223_344_073_709_551_615 {
            return random();
        }
        current = if current % 2 == 0 { current / 2 } else { 3 * current + 1 };
        steps += 1;
    }

    cache.insert(n, steps);
    steps
}

fn find_largest_sequence() {
    let mut cache = FxHashMap::default();
    let mut max_sequence_length = 1;
    let mut current_sequence_length = 1;
    let mut previous_steps = collatz_steps_iterative(2, &mut cache);
    let mut n = 9_500_000_000;
    let mut milestone = 10_000_000_000;

    loop {
        if n > milestone && n < milestone + max_sequence_length {
            println!("{} reached!", milestone);
            milestone += 1_000_000_000;
        }
        let mut curr_steps = collatz_steps_iterative(n, &mut cache);
        if curr_steps == previous_steps {
            current_sequence_length += 1;
            n += 1;
            if current_sequence_length > max_sequence_length {
                max_sequence_length = current_sequence_length;
                println!("{} ||||||||||||||||||||||||||||||||||||| {}", n, max_sequence_length);
            }
        } else {
            let mut skip_to = n + max_sequence_length;
            let m = skip_to;
            previous_steps = collatz_steps_iterative(skip_to, &mut cache);
            curr_steps = previous_steps;
            current_sequence_length = 1;
            while n < skip_to && curr_steps == previous_steps {
                skip_to -= 1;
                curr_steps = collatz_steps_iterative(skip_to, &mut cache);
                if curr_steps == previous_steps {
                    current_sequence_length += 1;
                } else {
                    break;
                }
            }
            n = m + 1;
        }
    }
}

fn main() {
    // let limit = 200_000_000_000;
    let start_time = Instant::now();
    find_largest_sequence();
    let duration = start_time.elapsed();
    println!("Time taken: {:?}", duration);
}
