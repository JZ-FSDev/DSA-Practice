#include <stdio.h>

int sumEven(int max)
{
    int sum = 0;

    for (int i = 0; i < max; i++)
    {
        if (i % 2 == 0)
        {
            sum += i;
        }
    }
    return sum;
}

void printArray(int length, int array[])
{
    for (int i = 0; i < length; i++)
    {
        printf("%2d ", array[i]);
    }
    printf("\n");
}

void arrayCopy(int arrayFrom[], int arrayTo[], int start, int end, int length)
{
    int count;
    for (count = 0; count < length; count++)
    {
        arrayTo[start + count] = arrayFrom[start + count];
    }
}

int main(int numParms, char *parms[])
{
    // int ans = sumEven(100);
    // printf("The sum of evens is %d\n", ans);
    int first[] = {1, 2, 3};
    int second[] = {4, 5, 6};

    printArray(3, first);
    printArray(3, second);
}
