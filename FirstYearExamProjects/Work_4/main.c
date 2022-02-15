#include <stdio.h>
#include <stdlib.h>

FILE *ptr;

// Helpful source of information that I used: https://www.geeksforgeeks.org/data-structures/linked-list/


struct Phone {                      // declaration of my list
    long long int factory_numb;
    char model[20];
    float price;
    int quantity;
    struct Phone* next;     // pointer to the next element in the list
};

void price_above_average(struct Phone* phone, struct Phone** phone1){  // function which show you all phones with price above average

    struct Phone* temp = *phone1;  // using temp for the second loop

    float mid_price = 0;
    int counter = 0;

    while (phone != NULL) {     // because the pointer of the last element of the list is going to be NULL, so we stop there
        mid_price += phone->price;
        counter++;
        phone = phone->next;       // go for next element in the list
    }

    mid_price = mid_price/counter;                      // calculating the average price
    printf("Mid price is %2.2f \n\n", mid_price);

    printf("Phones with price above average: \n\n");
    while (temp != NULL) {
        if(temp->price > mid_price){                                    // printing the info for the phones which price is above average
            printf("  Factory Number is %lli \n", temp->factory_numb);
            printf("  The model is %s \n", temp->model);
            printf("  The price is %2.2f \n", temp->price);
            printf("  The quantity is %d \n\n", temp->quantity);
        }
        temp = temp->next;
    }

}

void printList(struct Phone* phone){        // just prints out information about all elements in the list

    printf("\nList of all phones: \n\n");
    while (phone != NULL) {
        printf("  Factory Number is %lli \n", phone->factory_numb);
        printf("  The model is %s \n", phone->model);
        printf("  The price is %2.2f \n", phone->price);
        printf("  The quantity is %d \n\n", phone->quantity);
        phone = phone->next;
    }

}

void print_by_fact_numb(struct Phone* phone){  // prints out info about specific phone by its factory number

    long long int fact_numb;
    printf("\nEnter the factory number of the phone you want to search for: ");
    scanf("%lli", &fact_numb);

    printf("\nPhone with factory number %lli: \n\n", fact_numb);
    while (phone != NULL) {
        if(phone->factory_numb == fact_numb){               // check if the factory number is equal to the searched one
        printf("  The model is %s \n", phone->model);
        printf("  The price is %2.2f \n", phone->price);
        printf("  The quantity is %d \n\n", phone->quantity);
        return;
        }
        phone = phone->next;
    }
    printf("None.\n\n");

}

void clean_stdin(void){         // we clean something about the scanf just so my gets() function works
    int c;
    while ((c = getchar()) != '\n' && c != EOF)
        ;
}

void add_Phone(struct Phone** head_ref, long long int fact_number){     // function that adds element to the end of the list

    /* allocate the new phone */
    struct Phone* new_phone = NULL;
    new_phone = (struct Phone*)malloc(sizeof(struct Phone));

    struct Phone *last = *head_ref;

    /* put in the data */

    new_phone->factory_numb = fact_number;

    clean_stdin();  // cleaning some stuff

    printf("Type the model of the phone, maximum 20 char: ");
    gets(new_phone->model);

    printf("Set the price of the phone: ");
    scanf("%f", &new_phone->price);

    printf("Set the quantity of the phone: ");
    scanf("%d", &new_phone->quantity);

    /* This new phone is going to be the last phone, so make next
          of it as NULL */
    new_phone->next = NULL;

    /* If the Linked List is empty, then make the new phone as head */
    if (*head_ref == NULL)
    {
       *head_ref = new_phone;
       return;
    }

    /* Else traverse till the last phone */
    while (last->next != NULL){
        last = last->next;
    }

    /* Change the next of last phone */
    last->next = new_phone;


    if((ptr = fopen("C:\\Users\\raich\\Documents\\programki\\Kursova_rabota_pik2\\phone_shop.bin", "wb")) == NULL){
        printf("Error! opening file");
        exit(1);
        }

    fwrite(&new_phone, sizeof(struct Phone), 1, ptr);


    return;
}

struct Phone* add_Quantity(struct Phone** phone, char model[], int numb){

    struct Phone *temp = *phone;

    while(temp != NULL){
        if(strcmp(temp->model, model) == 0){        // comparing two string arrays, the models
            temp->quantity += numb;                 // add quantity to the certain model
        }
        temp = temp->next;                          // go for the next element
    }

}

struct Phone* buy_Phone(struct Phone** phone, char model[], int numb){      // function for decreasing of the quantity and removing the phone from the list if it's out of stock

    struct Phone *temp = *phone;
    struct Phone *prev;     // we use this so we can connect the pointer of the previous item to item next to which we delete

    while(temp != NULL){
        if(strcmp(temp->model, model) == 0){        // comparing two string arrays, the models
            if(temp->quantity < 1){
                printf("\nThere are no more of this model. \n");      // this actually can't happen but
                return;
            }
            else if(temp->quantity >= numb){
                temp->quantity = temp->quantity - numb;     // decreasing the quantity of the item we want
                if(temp->quantity == 0){
                    printf("\nThis was the last one of this model \n");
                    /* Delete phone with zero quantity */
                    prev->next = temp->next;    // Unlink the node from linked list
                    free(temp); // Free memory
                    return;
                }
                else{
                return temp->quantity;
                }
            }
            else{
                printf("\nThere are only %d in stock. \n", temp->quantity);  // if there are no enough items to be bought
                return;
            }
            break;
        }
        prev = temp;
        temp = temp->next;

    }

}

void read_Binary(struct Phone** phone){

    struct Phone *temp = *phone;

    if((ptr = fopen("C:\\Users\\raich\\Documents\\programki\\Kursova_rabota_pik2\\phone_shop.bin", "rb")) == NULL){
        printf("Error! opening file");
        exit(1);
    }

    fread(&temp, sizeof(struct Phone*), 1, ptr);

    while(temp != NULL){

        printf("  Factory Number is %lli \n", temp->factory_numb);
        printf("  The model is %s \n", temp->model);
        printf("  The price is %2.2f \n", temp->price);
        printf("  The quantity is %d \n\n", temp->quantity);

        temp = temp->next;
    }

    fclose(ptr);

}

int main()
{
    struct Phone* phone1 = NULL;
    struct Phone* phone2 = NULL;
    struct Phone* phone3 = NULL;        // create our items

    // allocate 3 nodes in the heap
    phone1 = (struct Phone*)malloc(sizeof(struct Phone));
    phone2 = (struct Phone*)malloc(sizeof(struct Phone));       // allocating some memory
    phone3 = (struct Phone*)malloc(sizeof(struct Phone));

    // Because I don't know why I cant print char arrays with %s from linked lists
    char model_1[20];
    strcpy(model_1, "Samsung Galaxy S10");      // i use strcpy() because otherwise the output of the char arrays (only in the linked list) is unreadable for some reason
    char model_2[20];
    strcpy(model_2, "Iphone 11");
    char model_3[20];
    strcpy(model_3, "Huawei P30 Pro");

    phone1->factory_numb = 111111111111;    // assign data in first phone
    strcpy(phone1->model, model_1);
    phone1->price = 950;
    phone1->quantity = 4;
    phone1->next = phone2;  // link first phone with second

    phone2->factory_numb = 111111111112;    // assign data in second phone
    strcpy(phone2->model, model_2);
    phone2->price = 1100;
    phone2->quantity = 6;
    phone2->next = phone3;

    phone3->factory_numb = 111111111113;    // assign data in third phone
    strcpy(phone3->model, model_3);
    phone3->price = 899.99;
    phone3->quantity = 8;
    phone3->next = NULL;

    int option;
    int choice;
    char model1[20];
    char model2[20];
    long long int fact_number = 111111111114;
    int buy_quantity;
    int add_quantity;

    if((ptr = fopen("C:\\Users\\raich\\Documents\\programki\\Kursova_rabota_pik2\\phone_shop.bin", "wb")) == NULL){
        printf("Error! opening file");
        exit(1);
    }

    fwrite(&phone1, sizeof(struct Phone), 1, ptr);
    fwrite(&phone2, sizeof(struct Phone), 1, ptr);
    fwrite(&phone3, sizeof(struct Phone), 1, ptr);

    fclose(ptr);

    for(;;){        // that is the loop I use for my menu
        printf("\nOptions are: \n\n1 - Add a phone. \n2 - Buy phone/phones. \n3 - Show phones with price above average. \n4 - Show phone details by his factory number. \n5 - Show information about all phones. \n6 - Add quantity to specific phone. \n7 - Read binary file. \n8 - Exit.");
        printf("\n\nPick a option: ");
        scanf("%d", &option);
        if(option == 1){
            do{
                add_Phone(&phone1, fact_number);
                fact_number++;                      // because we need different factory number for every new phone
                printf("\nDo you want to add another phone ?\n1 - yes\n2 - no\nPick a option: ");
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
            printf("\nWhich phone do you want to buy, enter the brand and model: ");
            gets(model1);
            printf("\nHow many phones do you want to buy: ");
            scanf("%d", &buy_quantity);
            buy_Phone(&phone1, model1, buy_quantity);
        }
        else if(option == 3){
            price_above_average(phone1, &phone1);
        }
        else if(option == 4){
            print_by_fact_numb(phone1);
        }
        else if(option == 5){
            printList(phone1);
        }
        else if(option == 6){
            clean_stdin();
            printf("\nWhich phone do you want to add quantity, enter the brand and model: ");
            gets(model2);
            printf("\nHow many phones do you want to add: ");
            scanf("%d", &add_quantity);
            add_Quantity(&phone1, model2, add_quantity);
        }
        else if(option == 7){
            read_Binary(&phone1);
        }
        else if(option == 8){
            break;
        }
        else{
            printf("\nInvalid option. Please, try again.\n\n");     // wrong input handling
        }
    }
    return 0;
}
