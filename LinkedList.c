#include <stdlib.h>
#include <stdio.h>
#include <assert.h>
#include <string.h>

typedef struct NODE Node;

struct NODE{
    int num;
    Node *next;
};

void insertAscended(int num);
void validateList();
int removeLastItem();
void printList();

void insertAscended(int thisNum){
    Node *prev = top;
    Node *curr = NULL;
    Node *toLink = malloc(sizeof(Node));

    if(toLink != NULL){
        toLink -> num = thisNum;
        toLink -> next = NULL;
        if(prev == NULL){
            top = toLink;
        }else{
            if(toLink -> num < top -> num){
                toLink -> next = top;
                top = toLink;
            }else{
                curr = prev -> next;
                while(curr != NULL && toLink -> num > curr -> num){
                    prev = prev -> next;
                    curr = curr -> next;
                }
                prev -> next = toLink;
                toLink -> next = curr;
            }
        }
        numNodes++;
    }
}

int removeLastItem(){
    Node *prev = top;
    Node *curr = NULL;
    int deleted = 0;

    // Precondition
    validateList();

    if(prev != NULL){
        curr = prev -> next;

        if(curr == NULL){
            top = NULL;
            free(prev);
        }else{
            while(curr -> next != NULL){
                prev = prev -> next;
                curr = curr -> next;
            }
            prev -> next = NULL;
            free(curr);
        }
        numNodes--;
        deleted = 1;
    }

    // Postcondition
    validateList();

    return deleted;
}

int removeFirst(){
    int result = 0;
    Node *temp;

    // Precondition
    validateList();

    if(top != NULL){
        temp = top;
        top = top -> next;
        free(temp);
        numNodes--;
        result = 1;
    }

    // Postcondition
    validateList();

    return result;
}
