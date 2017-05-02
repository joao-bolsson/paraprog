#include <string>
#include <map>
#include <list>
#include <iostream>

using namespace std;

class Tag {
private:
    string name;
    map<string, string> attributes;
    list<Tag> childs;

public:

    Tag(string name) {
        this->name = name;
    }

    void addAttribute(string key, string value) {
        attributes[key] = value;
    }

    void addTag(Tag tag) {
        this->childs.push_back(tag);
    }

    string toString() const {
        string tag = "<" + this->name;
        for (map<string, string>::const_iterator iter = attributes.begin(); iter != attributes.end(); iter++) {
            tag += " " + iter->first + "=\"" + iter->second + "\"";
        }

        tag += ">\n";

        for (list<Tag>::const_iterator list_iter = childs.begin(); list_iter != childs.end(); list_iter++) {
            tag += (*list_iter).toString();
        }

        tag += "</" + this->name + ">\n";
        return tag;
    }

};

