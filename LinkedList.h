
#ifndef LAB8_LINKED_LIST
#define LAB8_LINKED_LIST

#include <stdio.h>
#include <stdlib.h>

#define REMOVE_SUCCESS 0
#define REMOVE_FAILED 1

#define UNIQUE_ADD_SUCCESS 0
#define UNIQUE_ADD_FAILED 1

#define ITEM_NOT_FOUND 0
#define ITEM_FOUND 1

typedef struct Node {
    int data;
    struct Node* next;
} Node;

typedef struct LinkedList {
    Node* head;
} LinkedList;


/*
    If a linked list is empty, its head pointer is NULL (not the list pointer itself)

    ALL OF YOUR FUNCITONS SHOULD CHECK FOR NULL BEFORE USING ANY POINTERS
    THAT INCLUDES PARAMETERS PASSED IN AS ARGUMENTS
    (as in, I might pass NULL into your function)

    If a NULL pointer is passed, just return
*/

LinkedList* createList(void);
void deleteList(LinkedList**);
void clearList(LinkedList*);

void addItemToEnd(LinkedList*, int);
void insertItemInFront(LinkedList*, int);
int insertIfItemNotInList(LinkedList*, int);
int removeFirstAppearance(LinkedList*, int);
int isItemInList(LinkedList*, int);

//DO NOT IMPLEMENT THESE, THESE ARE ALREADY DONE FOR YOU
void printList(LinkedList*);
void printNode(Node*);

#endif