#include <stdio.h>
#include <stdlib.h>

#include "LinkedList/LinkedList.h"

int main() {
    printf("Creating list...\n");
    LinkedList* myList = createList();
    if (myList == NULL) {
        printf("Error: createList returned NULL\n");
        return 1;
    }

    // these should not cause any problems or throw errors or crash the program
    // they should do nothing
    insertItemInFront(NULL, 0);
    addItemToEnd(NULL, 0);
    removeFirstAppearance(NULL, 0);
    deleteList(NULL);
    isItemInList(NULL, 0);

    // 2. Insert Items
    printf("Adding items...\n");
    insertItemInFront(myList, 10);
    insertItemInFront(myList, 20);
    addItemToEnd(myList, 30);
    addItemToEnd(myList, 40);

    // Expected: 20 -> 10 -> 30 -> 40
    printf("Current List (Expect: 20 10 30 40):\n");
    printList(myList);

    // 1. Search for an item that exists (20)
    printf("Searching for 20 (Expect Found)...\n");
    int found = isItemInList(myList, 20);
    if (found == ITEM_FOUND) {
        printf("Result: FOUND\n");
    } else {
        printf("Result: NOT FOUND (Error)\n");
    }

    // 2. Search for an item that does NOT exist (500)
    printf("Searching for 500 (Expect Not Found)...\n");
    found = isItemInList(myList, 500);
    if (found == ITEM_NOT_FOUND) {
        printf("Result: NOT FOUND\n");
    } else {
        printf("Result: FOUND (Error)\n");
    }

    // 3. Remove Items
    printf("\nRemoving 10 (Expect Success)...\n");
    int result = removeFirstAppearance(myList, 10);
    if (result == REMOVE_SUCCESS) {
        printf("Result: SUCCESS\n");
    } else {
        printf("Result: FAILED\n");
    }

    printf("Removing 99 (Expect Failed)...\n");
    result = removeFirstAppearance(myList, 99);
    if (result == REMOVE_SUCCESS) {
        printf("Result: SUCCESS\n");
    } else {
        printf("Result: FAILED\n");
    }

    printf("Current List (Expect: 20 30 40):\n");
    printList(myList);

    // 4. Cleanup
    printf("\nDeleting list...\n");
    deleteList(&myList);
    printf("List deleted.\n");

    if (myList != NULL) {
        printf("List not set to NULL\n");
    }

    
    return 0;
}