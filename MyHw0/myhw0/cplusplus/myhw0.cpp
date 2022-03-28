#include <iostream>
#include <map>
#include <unordered_set>
#include <cstring>
#include <vector>

using namespace std;

int main() {

    map<string, unordered_set<int>> dataMap;
    vector<string> ordered_list;

    for (string line; getline(cin, line);) {
        if (line.empty()) {
            break;
        }
        size_t pos = line.find("|");
        string split_outcome[2]{
                line.substr(0, pos),
                line.substr(pos + 1, line.length())
        };

        string key = split_outcome[0];
        int value = stoi(split_outcome[1]);

        if (dataMap.count(key) == 1) {
            dataMap.find(key)->second.insert(value);
        } else {
            ordered_list.push_back(key);
            unordered_set<int> valueSet;
            valueSet.insert(value);
            dataMap[key] = valueSet;
        }
    }

    map<string, string> outputMap;
    for (auto const &e: dataMap) {
        outputMap[e.first] = to_string(e.second.size());
    }

    for (string vector_key: ordered_list) {
        auto it = outputMap.find(vector_key);
        string size_value = it->second;
        cout << vector_key << "|" << size_value << endl;
    }
    return 0;
}
