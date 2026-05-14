#include <stdio.h>
#include <stdlib.h>



//  Prompt for length
int readInitialLength()
{
    int length;
    do {
        printf("Enter initial array length (>=1): ");
        scanf("%d", &length);
    } while (length < 1);
    return length;
}

// Allocate array, fill values
int *createAndFill(int length)
{
    int *array = malloc(sizeof(int) * length);
    if (array == NULL)
    {
        printf("Memory allocation failed. ");
        exit(1);
    }

    for (int i = 0; i < length; i++)
    {
        printf("Enter integer #%d: ", i + 1);
        scanf("%d", &array[i]);
    }

    return array;
}

// Display menu & return user choice
int menu()
{
    int choice;
    printf(" Menu: ");
    printf("1) Sort Array ");
    printf("2) Add Item ");
    printf("3) Find & Remove Item ");
    printf("4) Quit ");

    printf("Enter choice: ");
    scanf("%d", &choice);
    return choice;
}

//1 Print sorted array result
void printSortedArray(int *array, int length)
{
    printf("Sorted Array: ");
    for (int i = 0; i < length; i++)
        printf("%d ", array[i]);
    printf(" ");
}

//2 Add item (resize array by +1)
int *addItem(int *length, int *array)
{
    int newLength = *length + 1;
    int *newArr = malloc(sizeof(int) * newLength);

    if (newArr == NULL)
    {
        printf("Memory allocation failed. ");
        return array;
    }

    for (int i = 0; i < *length; i++)
        newArr[i] = array[i];

    printf("Enter new integer: ");
    scanf("%d", &newArr[newLength - 1]);

    free(array);
    *length = newLength;
    return newArr;
}

//3 Get value to search for
int readValue()
{
    int val;
    printf("Enter value to find and remove: ");
    scanf("%d", &val);
    return val;
}

//3  Remove element by index
int* removeItem(int index, int *array, int *length)
{
    int newLength = *length - 1;
    int *newArr = malloc(sizeof(int) * newLength);

    if (newArr == NULL)
    {
        printf("Memory allocation failed. ");
        return array;
    }

    for (int i = 0, j = 0; i < *length; i++)
    {
        if (i != index)
        {
            newArr[j] = array[i];
            j++;
        }
    }

    free(array);
    *length = newLength;
    return newArr;
}

// Release memory
void cleanUp(int *array)
{
    free(array);
}

//  Linear search
int linearSearch(int value, int *array, int length)
{
    for (int i = 0; i < length; i++)
        if (array[i] == value)
            return i;
    return -1;
}


void stuSort(int *array, int length)
{
    for (int i = 0; i < length - 1; i++)
    {
        int minIndex = i;
        for (int j = i + 1; j < length; j++)
        {
            if (array[j] < array[minIndex])
                minIndex = j;
        }

        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
    }
}

int main()
{
    int *array = NULL;
    int length, choice, value, index;

    length = readInitialLength();
    array = createAndFill(length);

    do
    {
        choice = menu();
        switch(choice)
        {
            case 1:
                stuSort(array, length);
                printSortedArray(array, length);
                break;

            case 2:
                array = addItem(&length, array);
                break;

            case 3:
                value = readValue();
                index = linearSearch(value, array, length);
                if (index != -1)
                    array = removeItem(index, array, &length);
                else
                    printf("Value not found.\n");
                break;
        }
    } while(choice != 4);

    cleanUp(array);
    array = NULL;

    return 0;
} // end main
