#include <stdio.h>
#include <stdlib.h>

struct User {                      // declaration of my list of users
    long long int u_number;
    char names[80];
    char address[80];
    char egn[20];
    int taken_books;
    struct User* next;     // pointer to the next element in the list
};

void clean_stdin(void){         // we clean something about the scanf just so my gets() function works
    int c;
    while ((c = getchar()) != '\n' && c != EOF)
        ;
}

void add_User(struct User** head_ref, long long int user_number){     // function that adds element to the end of the list

    /* allocate the new user */
    struct User* new_user = NULL;
    new_user = (struct User*)malloc(sizeof(struct User));

    struct User *last = *head_ref;

    /* put in the data */

    new_user->u_number = user_number;

    clean_stdin();  // cleaning the scanf so my gets can work properly

    printf("Enter the names of the user: ");
    gets(new_user->names);

    printf("Enter the address of the user: ");
    gets(new_user->address);

    printf("Enter the egn of the user: ");
    gets(new_user->egn);

    printf("Enter how many books the user will take: ");
    scanf("%d", &new_user->taken_books);

    /* This new user is going to be the last user, so make next
          of it as NULL */
    new_user->next = NULL;

    /* If the Linked List is empty, then make the new user as head */
    if (*head_ref == NULL){

       *head_ref = new_user;
       return;
    }

    /* Else traverse till the last user */
    while (last->next != NULL){

        last = last->next;
    }

    /* Change the next of last user */
    last->next = new_user;
    return;
}

void best_User(struct User** user1){  // function which show you all users with price above average

    struct User* temp = *user1;  // using temp for the second loop
    struct User *prev; // for comparing
    prev = temp;

    int books = 0;

    while (temp != NULL){     // because the pointer of the last element of the list is going to be NULL, so we stop there

        if(temp->taken_books > prev->taken_books){
            books = temp->taken_books;
        }
        prev = temp;
        temp = temp->next;

    }

    temp = *user1;

    if(books < temp->taken_books){
        books = temp->taken_books;      // because the while up there doesn't really compare the first and the second element properly
    }

    printf("\nUser/s with most taken books: \n");
    while(temp != NULL){
        if(temp->taken_books == books){
            printf("\n Number: %lli", temp->u_number);
            printf("\n Names: %s", temp->names);
            printf("\n Address: %s", temp->address);
            printf("\n Egn: %s", temp->egn);
            printf("\n Taken books: %d \n", temp->taken_books);
        }
        temp = temp->next;
    }
}

struct User* remove_User(struct User** user, long long int u_numb){      // function for removing the user from the list if he has not taken any books.

    struct User *temp = *user;
    struct User *prev;     // we use this so we can connect the pointer of the previous user to user that is next to which we deleted
    prev = temp;

    while(temp != NULL){
        if(temp->u_number == u_numb){        // comparing the two user numbers
            if(temp->taken_books == 0){
                prev->next = temp->next;    // Unlink the node from linked list
                free(temp); // Free memory
                printf("\nUser removed.");
                return;
            }
            else{
                printf("This user has books.");
            }
        }
        prev = temp;
        temp = temp->next;
    }
}

char *split_Names(struct User* user){

    char lname[20]= "\0";
    char mname[20]= "\0";

    char *ptr = malloc(20 * sizeof(char));

    if(ptr == NULL)
        return NULL;

    int count = 0;
    int i,l,k;
    l = 0;
    k = 0;

    for(i=0; i<strlen(user->names); i++){

        if(count == 1)
            mname[k++] = user->names[i];

        if(count == 2)
            lname[l++] = user->names[i];

        if(user->names[i] == ' ')
        count++;

    }

    ptr = lname;

    if(strlen(lname)==0){
        ptr = mname;
        return ptr;
    }
    else{
        return ptr;
    }

}

void print_Users(struct User* user){        // prints out all users

    printf("\nList of all user: \n\n");
    while (user != NULL) {
        printf("\n Number: %lli", user->u_number);
        printf("\n Names: %s", user->names);
        printf("\n Address: %s", user->address);
        printf("\n Egn: %s", user->egn);
        printf("\n Taken books: %d \n", user->taken_books);
        user = user->next;
    }

}

void search_User(struct User** user, char l_name[20]){

    struct User *temp = *user;
    char last_name[20];

    while(temp != NULL){

        strcpy(last_name, split_Names(temp));

        if(strcmp(last_name, l_name) == 0){
            printf("\n Number: %lli", temp->u_number);
            printf("\n Names: %s", temp->names);
            printf("\n Address: %s", temp->address);
            printf("\n Egn: %s", temp->egn);
            printf("\n Taken books: %d \n", temp->taken_books);
        }

        temp = temp->next;
    }

    // I didn't make print for nobody with this last name.

}


int main()
{

    struct User* user1 = NULL;
    struct User* user2 = NULL;
    struct User* user3 = NULL;        // create our users

    // allocate 3 nodes in the heap
    user1 = (struct User*)malloc(sizeof(struct User));
    user2 = (struct User*)malloc(sizeof(struct User));
    user3 = (struct User*)malloc(sizeof(struct User));

    char user1_address[80];
    strcpy(user1_address, "Sofia");      // i use strcpy() because otherwise the output of the char arrays is wrong (only in the linked list)
    char user2_address[80];
    strcpy(user2_address, "Plovdiv");
    char user3_address[80];
    strcpy(user3_address, "Varna");

    char user1_names[80];
    strcpy(user1_names, "Ivan Petkov Ivanov");
    char user2_names[80];
    strcpy(user2_names, "Georgi Ivanov Georgiev");
    char user3_names[80];
    strcpy(user3_names, "Mihail Georgiev Mishev");

    char user1_egn[20];
    strcpy(user1_egn, "9552186332");
    char user2_egn[20];
    strcpy(user2_egn, "9643178441");
    char user3_egn[20];
    strcpy(user3_egn, "9233253412");

    user1->u_number = 11111111;
    strcpy(user1->address, user1_address);
    strcpy(user1->egn, user1_egn);
    user1->taken_books = 4;
    strcpy(user1->names, user1_names);
    user1->next = user2;

    user2->u_number = 11111112;
    strcpy(user2->address, user2_address);
    strcpy(user2->egn, user2_egn);
    user2->taken_books = 1;
    strcpy(user2->names, user2_names);
    user2->next = user3;

    user3->u_number = 11111113;
    strcpy(user3->address, user3_address);
    strcpy(user3->egn, user3_egn);
    user3->taken_books = 3;
    strcpy(user3->names, user3_names);
    user3->next = NULL;

    int option;
    int choice;
    long long int u_numb = 11111114;
    long long int u_numb1;

    for(;;){        // endless loop (menu)
        printf("\nOptions are: \n\n1 - Add an user. \n2 - Remove an user. \n3 - Show user/s with most taken books.\n4 - Show all users. \n5 - Show user info by his last name. \n6 - Exit.");
        printf("\n\nPick a option: ");
        scanf("%d", &option);
        if(option == 1){
            do{
                add_User(&user1, u_numb);
                u_numb++;                      // we need different user number for every new user
                printf("\nDo you want to add another user ?\n1 - yes\n2 - no\nPick a option: ");
                scanf("%d", &choice);
                if(choice != 1 && choice != 2){
                        printf("\nInvalid option.\n");
                    break;
                }
            }
            while(choice == 1);
        }
        else if(option == 2){
            printf("\nWhich user do you want to remove, enter his user number: ");
            scanf("%lli", &u_numb1);
            remove_User(&user1, u_numb1);
        }
        else if(option == 3){
            best_User(&user1);
        }
        else if(option == 4){
            print_Users(user1);
        }
        else if(option == 5){
            clean_stdin();
            char l_name[20];
            printf("Enter the last name of the user: ");
            gets(l_name);

            search_User(&user1, l_name);

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
