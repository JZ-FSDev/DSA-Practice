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
