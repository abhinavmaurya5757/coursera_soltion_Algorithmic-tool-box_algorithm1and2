#include <iostream>
#include <vector>
#include <algorithm>
#include <math.h>

using std::vector;
using std::min;

vector<int> optimal_sequence(int n) {
  std::vector<int> sequence;
  while (n >= 1) {
    sequence.push_back(n);
    if (n % 3 == 0) {
      n /= 3;
    } else if (n % 2 == 0) {
      n /= 2;
    } else {
      n = n - 1;
    }
  }
  reverse(sequence.begin(), sequence.end());
  return sequence;
}

vector<int> dynamic_sequence(int n) {
  vector<int> a(n+1);
  vector<int> count_index;
  vector<int> sequence;
  vector<int> option_list;

  a[1] = 1;
  for(int i=2; i<a.size(); i++) {
    count_index.push_back(i-1);
    if (i%2 == 0)
      count_index.push_back(i/2);
    if (i%3 == 0)
      count_index.push_back(i/3);
    int min_count = pow(2, 31)-1;
    for (int num : count_index) {
      min_count = std::min(min_count, a[num]);
    }
    a[i] = min_count + 1;
  }

  int i = n;
  sequence.push_back(i);
  while (i != 1) {
    option_list.push_back(i-1);
    if (i%2 == 0)
      option_list.push_back(i/2);
    if (i%3 == 0)
      option_list.push_back(i/3);

    int min_operation = pow(2, 31)-1;
    int min_value = pow(2, 31)-1;
    for (int option : option_list) {
      if (a[option] < min_operation)
        min_value = option;
    }
    i = min_value;
    sequence.push_back(i);
  }
  reverse(sequence.begin(), sequence.end());
  return sequence;
}

int main() {
  int n;
  std::cin >> n;
  vector<int> sequence = dynamic_sequence(n);
  std::cout << sequence.size() - 1 << std::endl;
  for (size_t i = 0; i < sequence.size(); ++i) {
    std::cout << sequence[i] << " ";
  }
}