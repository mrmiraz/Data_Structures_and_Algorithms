#include<bits/stdc++.h>
using namespace std;

struct item{
    double weight, price, unitPrice;
};
item a[100000];
int n;
bool compare(item a, item b){
    return a.unitPrice > b.unitPrice;
}

double knapsack(int maxWeight){
    double remainingWeight = maxWeight;
    double maxPrice = 0;

    for(int i = 0; i < n; i++){
        if(remainingWeight > a[i].weight){
            remainingWeight -= a[i].weight;
            maxPrice += a[i].price;
        }
        else{
            maxPrice += a[i].unitPrice * remainingWeight;
            break;
        }
    }
    return maxPrice;
}

void bubbleSort(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n-i-1; j++){
            if(a[j].unitPrice < a[j+1].unitPrice){
                swap(a[j], a[j+1]);
            }
        }
    }
}

int partition(int lb, int ub){
    int pivot = ub;
    int i = lb-1;
    for(int j = lb; j < ub; j++){
        if(a[j].unitPrice > a[pivot].unitPrice){
            swap(a[++i], a[j]);
        }
    }
    swap(a[++i], a[pivot]);
    return i;
}

void quickSort(int lb, int ub){
    if(lb >= ub)return;
    int q = partition(lb, ub);
    quickSort(lb, q-1);
    quickSort(q+1, ub);
}

void merge(int lb, int mid, int ub){
    int i = lb, j = mid+1, k = 0;
    item result[ub-lb+1];
    while(i <= mid && j <= ub){
        if(a[i].unitPrice > a[j].unitPrice){
            result[k++] = a[i++];
        }
        else{
            result[k++] = a[j++];
        }
    }

    while(i <= mid){
        result[k++] = a[i++];
    }
    while(j <= ub){
        result[k++] = a[j++];
    }
    k = 0;
    for(int i = lb; i <= ub; i++){
        a[i] = result[k++];
    }
    return;
}
void mergeSort(int lb, int ub){

    if(lb >= ub) return;
    int mid = (ub+lb)/2;
    mergeSort(lb, mid);
    mergeSort(mid+1, ub);
    merge(lb, mid, ub);
}


int main(){
    cin >> n;
    // int arr[8] = {1, 7, 12, 3, 5, 20, 11, 23};
    
    for(int i = 0; i < n; i++){
        cin >> a[i].weight >> a[i].price;
        a[i].unitPrice = a[i].price/a[i].weight;
    }
    // sort(&a[0], &a[n], compare);
    // bubbleSort();
    quickSort(0, n-1);
    // mergeSort(0, n-1);
    
    for(int i = 0; i < n; i++){
        cout << a[i].weight << " " << a[i].price << " " << a[i].unitPrice << endl; 
    }
    cout << "Max Profit " << knapsack(8) << endl;

    return 0;
}
