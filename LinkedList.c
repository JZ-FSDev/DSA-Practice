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
