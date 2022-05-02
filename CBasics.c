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
