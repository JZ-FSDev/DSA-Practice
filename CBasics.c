#include <stdio.h>
#include <string.h>

struct person{
    int age;
    char name[100];
};

int equalPerson(struct person person1, struct person person2){
    return person1.age == person2.age && person1.name == person2.name;
}

void printPerson(struct person person){
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



int main(int numParms, char *parms[])
{
    // int ans = sumEven(100);
    // printf("The sum of evens is %d\n", ans);
    // int first[] = {1, 2, 3};
    // int second[] = {4, 5, 6};

    // printArray(3, first);
    // printArray(3, second);

    int count = 100;
    struct person persons[count];
    for(int i = 0; i < count; i++){
        persons[i].age = i;
        char character[] = "moo";
        char temp[] = "cow";
        strcpy(persons[i].name, strncat(character, temp, 3));
    }
    for(int i = 0; i < count; i++){
        printPerson(persons[i]);
    }

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


