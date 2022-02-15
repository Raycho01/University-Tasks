#include <stdio.h>
#include <stdlib.h>


struct User {                      // declaration of my linked list
    char bank_number[10];
    char names[50];
    float money;
    int contain_months;
    struct User* next;     // pointer to the next element in the list
};


void clean_stdin(void){         // we clean something about the scanf just so my gets() function works
    int c;
    while ((c = getchar()) != '\n' && c != EOF)
        ;
}


void add_User(struct User** head_ref){     // function that adds element to the end of the list

    /* allocate the new user */
    struct User* new_user = NULL;
    new_user = (struct User*)malloc(sizeof(struct User));

    struct User *last = *head_ref;

    /* put in the data */

    clean_stdin();  // cleaning the scanf so my gets can work properly

    printf("Enter the names of the user: ");
    gets(new_user->names);

    printf("How much money do you want to deposit: ");
    scanf("%f", &new_user->money);

    clean_stdin();

    printf("Enter the bank number of the user: ");
    gets(new_user->bank_number);

    new_user->contain_months = 0;

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


void search_User(struct User** user, char bank_number[5]){

    struct User *temp = *user;

    while(temp != NULL){

        if(strcmp(bank_number, temp->bank_number) == 0){

            printf("\n Names: %s", temp->names);
            printf("\n Balance: %2.2f", temp->money);
            printf("\n Months in bank: %d", temp->contain_months);
            printf("\n User number is: %s \n", temp->bank_number);

        }

        temp = temp->next;
    }
}


struct User* remove_User(struct User** user, char bank_number[5]){      // function for removing the user from the list if he has not taken any books.

    struct User *temp = *user;
    struct User *prev;     // we use this so we can connect the pointer of the previous user to user that is next to which we deleted
    prev = temp;

    while(temp != NULL){

        if(strcmp(bank_number, temp->bank_number) == 0){        // comparing the two user numbers

                prev->next = temp->next;    // Unlink the node from linked list
                free(temp); // Free memory
                printf("\nUser removed.");
                return;
        }
        prev = temp;
        temp = temp->next;
    }
}


void balance_above_average(struct User* user, struct User** user1){  // function which show you all users with balance above average

    struct User* temp = *user1;  // using temp for the second loop

    float mid_balance = 0;
    int counter = 0;

    while (user != NULL) {     // because the pointer of the last element of the list is going to be NULL, so we stop there
        mid_balance += user->money;
        counter++;
        user = user->next;       // go for next element in the list
    }

    mid_balance = mid_balance/counter;                      // calculating the average balance
    printf("Mid balance is %2.2f \n\n", mid_balance);

    printf("Users with balance above average: \n\n");
    while (temp != NULL) {
        if(temp->money > mid_balance){                                    // printing the info for the users which balance is above average

            printf("\n Names: %s", temp->names);
            printf("\n Balance: %2.2f", temp->money);
            printf("\n Months in bank: %d", temp->contain_months);
            printf("\n User number is: %s \n", temp->bank_number);

        }
        temp = temp->next;
    }

}

void print_Users(struct User** user){        // prints out all users

    struct User* temp = *user;

    printf("\nList of all users: \n\n");
    while (temp != NULL) {

        printf("\n Names: %s", temp->names);
        printf("\n Balance: %2.2f", temp->money);
        printf("\n Months in bank: %d", temp->contain_months);
        printf("\n User number is: %s \n", temp->bank_number);

        temp = temp->next;
    }

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


    char user1_number[10];
    strcpy(user1_number, "a1bkd");      // i use strcpy() because otherwise the output of the char arrays is wrong (only in the linked list)
    char user2_number[10];
    strcpy(user2_number, "b3da2");
    char user3_number[10];
    strcpy(user3_number, "c1u2e");

    char user1_names[50];
    strcpy(user1_names, "Vladislav Keranov Ivanov");
    char user2_names[50];
    strcpy(user2_names, "Petko Atanasov Veselinov");
    char user3_names[50];
    strcpy(user3_names, "Elizabeth Hadjiiska Nikolinkova");

    strcpy(user1->names, user1_names);
    strcpy(user1->bank_number, user1_number);
    user1->money = 1000;
    user1->contain_months = 2;
    user1->next = user2;

    strcpy(user2->names, user2_names);
    strcpy(user2->bank_number, user2_number);
    user2->money = 2000;
    user2->contain_months = 5;
    user2->next = user3;

    strcpy(user3->names, user3_names);
    strcpy(user3->bank_number, user3_number);
    user3->money = 500;
    user3->contain_months = 3;
    user3->next = NULL;

    char user_numb1[5];
    char user_numb2[5];
    int option;


    for(;;){        // endless loop (menu)
        printf("\nOptions are: \n\n1 - Add an user. \n2 - Search for a user. \n3 - Remove a user. \n4 - Show user/s with balance above average.\n5 - Show all users.\n6 - Exit.");
        printf("\n\nPick an option: ");
        scanf("%d", &option);
        if(option == 1){

            add_User(&user1);

        }
        else if(option == 2){

            clean_stdin();
            printf("\nWhich user do you want to search for, enter his bank number: ");
            gets(user_numb1);
            search_User(&user1, user_numb1);

        }
        else if(option == 3){

            clean_stdin();
            printf("\nWhich user do you want to remove, enter his bank number: ");
            gets(user_numb2);
            remove_User(&user1, user_numb2);

        }
        else if(option == 4){

            balance_above_average(user1, &user1);

        }
        else if(option == 5){

            print_Users(&user1);

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
