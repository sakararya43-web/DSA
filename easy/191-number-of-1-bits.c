int hammingWeight(int n) {
    int s = 0;
    while(n>=1)
    {   
        int a=n%2;
        n=n/2;
        if(a==1)
        {
            s++;
        }
    }
    return s;
}