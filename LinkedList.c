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
