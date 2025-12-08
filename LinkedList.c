#include "LinkedList.h"
#include <stdlib.h>
#include <stdio.h>

Node* createNode(int); //prototype

/*
    Dynamically allocate a LinkedList and return the pointer
    The List's head pointer is NULL (there are no items in the list)

    Returns NULL if the allocation fails
*/
LinkedList* createList(void) {
    LinkedList* list = malloc(sizeof(LinkedList));
    if (list == NULL) return NULL;

    list->head = NULL;
    return list;
}

/*
    Given a pointer to a linked list pointer (LinkedList**):
    1. Free all nodes (you can call clearList)
    2. Free the LinkedList struct itself
    3. Set the original pointer (*list) to NULL
*/
void deleteList(LinkedList** list) {
    if (list == NULL || *list == NULL) {
        return;
    }

    clearList(*list);   // free all nodes
    free(*list);        // free LinkedList struct
    *list = NULL;       // last line of function
}

/*
    frees and removes ALL nodes in the list
*/
void clearList(LinkedList* list) {
    if (list == NULL) return;

    Node* cur = list->head;
    while (cur != NULL) {
        Node* next = cur->next;
        free(cur);
        cur = next;
    }
    list->head = NULL;
}

/*
    create a new node with the given data and add it to the end of the list
*/
void addItemToEnd(LinkedList* list, int data) {
    if (list == NULL) return;

    Node* newNode = createNode(data);
    if (newNode == NULL) return;

    if (list->head == NULL) {
        list->head = newNode;
        return;
    }

    Node* cur = list->head;
    while (cur->next != NULL) {
        cur = cur->next;
    }
    cur->next = newNode;
}

/*
    create a new node with the given data and add it to the front
*/
void insertItemInFront(LinkedList* list, int data) {
    if (list == NULL) return;

    Node* newNode = createNode(data);
    if (newNode == NULL) return;

    newNode->next = list->head;
    list->head = newNode;
}

/*
    If "data" is not already in the list, insert it in front
*/
int insertIfItemNotInList(LinkedList* list, int data) {
    if (list == NULL) return UNIQUE_ADD_FAILED;

    if (isItemInList(list, data) == ITEM_FOUND)
        return UNIQUE_ADD_FAILED;

    insertItemInFront(list, data);
    return UNIQUE_ADD_SUCCESS;
}

/*
    Remove first matching appearance of data
*/
int removeFirstAppearance(LinkedList* list, int data) {
    if (list == NULL || list->head == NULL)
        return REMOVE_FAILED;

    Node* cur = list->head;
    Node* prev = NULL;

    while (cur != NULL) {
        if (cur->data == data) {
            if (prev == NULL) {
                list->head = cur->next;
            } else {
                prev->next = cur->next;
            }
            free(cur);
            return REMOVE_SUCCESS;
        }
        prev = cur;
        cur = cur->next;
    }

    return REMOVE_FAILED;
}

/*
    Search list for data
*/
int isItemInList(LinkedList* list, int data) {
    if (list == NULL) return ITEM_NOT_FOUND;

    Node* cur = list->head;
    while (cur != NULL) {
        if (cur->data == data)
            return ITEM_FOUND;
        cur = cur->next;
    }
    return ITEM_NOT_FOUND;
}

/*
    Helper function — dynamically allocates and returns a node
*/
Node* createNode(int data) {
    Node* node = malloc(sizeof(Node));
    if (node == NULL) return NULL;

    node->data = data;
    node->next = NULL;
    return node;
}

// DO NOT MODIFY THESE PRINT FUNCTIONS
void printList(LinkedList* list) {
    if (list == NULL) return;
    Node* cur = list->head;
    while (cur) {
        printNode(cur);
        cur = cur->next;
    }
}

void printNode(Node* node) { printf("%d\n", node->data); 
}