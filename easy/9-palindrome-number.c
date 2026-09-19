bool isPalindrome(int x) {
    double n=x,a,b=0;
    while(x>0)
    { 
        a=x%10;
        b=b*10+a;
        x/=10;
    }
    if(n==b)
    {
        return true;
    } 
    else{
        return false;
    }
}