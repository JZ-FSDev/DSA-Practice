#include <stdio.h>
#include <string.h>

#define MAX_COUNT 100

struct person
{
    int age;
    char name[100];
};

typedef struct{
    enum
    {
        intType,
        doubleType
    } tag;
    union
    {
        int intValue;
        double doubleValue;
    } union1;
}MY_STRUCT;

typedef struct
{
    int size;
} ball;

int equalPerson(struct person person1, struct person person2)
{
    return person1.age == person2.age && person1.name == person2.name;
}

void printPerson(struct person person)
{
    printf("Name: %s  Age: %d\n", person.name, person.age);
}

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

int ballBig(ball b)
{
    return b.size > 2;
}

int main(int numParms, char *parms[])
{
    // int ans = sumEven(100);
    // printf("The sum of evens is %d\n", ans);
    // int first[] = {1, 2, 3};
    // int second[] = {4, 5, 6};

    // printArray(3, first);
    // printArray(3, second);

    struct person persons[MAX_COUNT];
    for (int i = 0; i < MAX_COUNT; i++)
    {
        persons[i].age = i;
        char character[] = "moo";
        char temp[] = "cow";
        char filler[100];
        strncat(filler, character, 3);
        strcpy(persons[i].name, filler);
        printPerson(persons[i]);
    }

    ball balls[MAX_COUNT];
    for (int i = 0; i < MAX_COUNT; i++)
    {
        balls[i].size = i;
        printf("Ball size: %d\n", balls[i].size);
        printf("Ball is large: %d\n", ballBig(balls[i]));
    }

    enum
    {
        FALSE,
        TRUE
    } boolean;

    boolean = FALSE;

    if (boolean == FALSE)
    {
        printf("boolean value: %d", boolean);
    }
    else
    {
        printf("boolean value: %d", boolean);
    }

    union MY_UNION
    {
        int intValue;
        double doubleValue;
    };
    union MY_UNION union1;

    // struct person person1;
    // struct person person2;
    // char personName1[] = "Jason";

    // person1.age = 25;
    // strcpy(person1.name, "Jason");
    // person2.age = 13;
    // strcpy(person2.name, "Lisa");
    // printPerson(person1);
    // printPerson(person2);
}
