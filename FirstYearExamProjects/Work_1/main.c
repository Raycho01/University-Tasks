#include <stdio.h>
#include <stdlib.h>

FILE *ptr;


struct Movie {                      // declaration of my list
    long long int n_number;
    char name[50];
    char producer[50];
    float time;
    int year;
    struct Movie* next;
};

void add_Movie(struct Movie** head_ref, long long int new_number){     // function that adds element to the end of the list

    struct Movie* new_movie = NULL;
    new_movie = (struct Movie*)malloc(sizeof(struct Movie));

    struct Movie *last = *head_ref;


    new_movie->n_number = new_number;

    clean_stdin();  // cleaning some stuff

    printf("Enter the name of the movie: ");
    gets(new_movie->name);

    printf("Enter the name of the producer: ");
    gets(new_movie->producer);

    printf("Set the time of the movie: ");
    scanf("%f", &new_movie->time);

    printf("Enter the year of the movie: ");
    scanf("%d", &new_movie->year);

    new_movie->next = NULL;

    if (*head_ref == NULL)
    {
       *head_ref = new_movie;
       return;
    }

    while (last->next != NULL){
        last = last->next;
    }

    last->next = new_movie;
    return;
}



void clean_stdin(void){         // we clean the scanf
    int c;
    while ((c = getchar()) != '\n' && c != EOF)
        ;
}



struct Movie* delete_Movie(struct Movie** movie, char producer1[]){      // function that deletes all movies of specific producer

    struct Movie *temp = *movie;
    struct Movie *prev;

    while(temp != NULL){
        if(strcmp(temp->producer, producer1) == 0){        // comparing two strings

            prev->next = temp->next;    // Unlink the node from linked list
            free(temp);                 // Free memory

        }

        prev = temp;
        temp = temp->next;

    }

}

void swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}

void bubbleSort(int arr[], int n)
{
   int i, j;
   for (i = 0; i < n-1; i++)

       // Last i elements are already in place
       for (j = 0; j < n-i-1; j++)
           if (arr[j] < arr[j+1])
              swap(&arr[j], &arr[j+1]);
}


int count_Func(struct Movie** movie){

    int counter = 0;
    struct Movie* temp = *movie;


    while (temp != NULL) {
        counter++;
        temp = temp->next;
    }


    return counter;

}


void print_by_Year(struct Movie** movie, int counter){

    struct Movie* temp = *movie;
    struct Movie* temp1;
    struct Movie* prev;
    prev = temp;
    temp1 = temp;


    int years[counter];

    int i, j;
    for (i = 0; i <= counter-1; i++){
        years[i] = temp->year;
        prev = temp;
        temp = temp->next;
    }

    temp = *movie;

    bubbleSort(years, counter);

        for(i=0; i<counter; i++){
            while(temp != NULL){
                if(years[i] == temp->year){
                    printf("%s - %d \n", temp->name, temp->year);
                }
                temp = temp->next;
            }
            temp = temp1;
        }



}

void longest_Movie(struct Movie** movie1){

    struct Movie* temp = *movie1;
    struct Movie* prev;
    prev = temp;

    float longest_time;

    while (temp != NULL) {
        if(temp->time > prev->time){
            longest_time = temp->time;
        }
        prev = temp;
        temp = temp->next;
    }

    temp = *movie1;

    while(temp != NULL){
        if(temp->time == longest_time){

            printf("\nThe name of the movie is %s \n", temp->name);
            printf("The producer of the movie is %s \n", temp->producer);
            printf("The number of the movie is %lli \n", temp->n_number);
            printf("The year of the movie is %d \n", temp->year);
            printf("The time of the movie is %2.2f min \n\n", temp->time);

        }
        temp = temp->next;
    }


}

void printList(struct Movie* movie){        // just prints out information about all elements in the list

    printf("\nList of all movies: \n\n");
    while (movie != NULL) {
        printf("The name of the movie is %s \n", movie->name);
        printf("The producer of the movie is %s \n", movie->producer);
        printf("The number of the movie is %lli \n", movie->n_number);
        printf("The year of the movie is %d \n", movie->year);
        printf("The time of the movie is %2.2f min \n\n", movie->time);
        movie = movie->next;
    }

}


void read_Binary(struct Movie** movie){

    struct Movie *temp = *movie;

    if((ptr = fopen("C:\\Users\\raich\\Documents\\programki\\kursova_adi\\movie_menu.bin", "rb")) == NULL){
        printf("Error! opening file");
        exit(1);
    }

    fread(&temp, sizeof(struct Movie*), 1, ptr);

    while(temp != NULL){

        printf("The name of the movie is %s \n", temp->name);
        printf("The producer of the movie is %s \n", temp->producer);
        printf("The number of the movie is %lli \n", temp->n_number);
        printf("The year of the movie is %d \n", temp->year);
        printf("The time of the movie is %2.2f min \n\n", temp->time);

        temp = temp->next;
    }

    fclose(ptr);

}


int main()
{

    struct Movie* movie1 = NULL;
    struct Movie* movie2 = NULL;

    // allocate 3 nodes in the heap
    movie1 = (struct Movie*)malloc(sizeof(struct Movie));
    movie2 = (struct Movie*)malloc(sizeof(struct Movie));

    char name_1[50];
    strcpy(name_1, "Avengers: Age of Ultron");
    char name_2[50];
    strcpy(name_2, "Lord of the Rings");

    char producer_1[50];
    strcpy(producer_1, "John Hudson");
    char producer_2[50];
    strcpy(producer_2, "Travis Rosten");

    movie1->n_number = 111111111111;    // assign data in the movies
    strcpy(movie1->name, name_1);
    strcpy(movie1->producer, producer_1);
    movie1->time = 180;
    movie1->year = 2004;
    movie1->next = movie2;  // link first node with second

    movie2->n_number = 111111111112;
    strcpy(movie2->name, name_2);
    strcpy(movie2->producer, producer_2);
    movie2->time = 220;
    movie2->year = 2001;
    movie2->next = NULL;

    int option;
    int choice;
    char del_producer[50];
    long long int n_numb = 111111111113;
    int counter;


    if((ptr = fopen("C:\\Users\\raich\\Documents\\programki\\kursova_adi\\movie_menu.bin", "wb")) == NULL){
        printf("Error! opening file");
        exit(1);
    }


    fwrite(&movie1, sizeof(struct Movie), 1, ptr);
    fwrite(&movie2, sizeof(struct Movie), 1, ptr);


    for(;;){        // the menu
        printf("\nOptions are: \n\n1 - Add a movie. \n2 - Remove movies by producer. \n3 - Show movies sorted by year. \n4 - Show longest movie. \n5 - Show information about all movies. \n6 - Exit.");
        printf("\n\nPick a option: ");
        scanf("%d", &option);
        if(option == 1){
            do{
                add_Movie(&movie1, n_numb);
                n_numb++;
                printf("\nDo you want to add another movie ?\n1 - yes\n2 - no\nPick a option: ");
                scanf("%d", &choice);
                if(choice != 1 && choice != 2){
                        printf("\nInvalid option.\n");
                    break;
                }
            }
            while(choice == 1);
        }
        else if(option == 2){
            clean_stdin();
            printf("\nEnter name of producer: ");
            gets(del_producer);
            delete_Movie(&movie1, del_producer);
        }
        else if(option == 3){
            counter = count_Func(&movie1);
            print_by_Year(&movie1, counter);
        }
        else if(option == 4){
            longest_Movie(&movie1);
        }
        else if(option == 5){
            read_Binary(&movie1);
        }
        else if(option == 6){
            break;
        }
        else{
            printf("\nInvalid option. Please, try again.\n\n");
        }

    }


    return 0;
}
