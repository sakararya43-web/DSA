class Solution {
    class Pair
    {
        String first;
        int second;
        Pair(String first,int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++)
        {
            set.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            String word = p.first;
            int ans = p.second;
            if(word.equals(endWord)) return ans;

            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedString = new String(replacedCharArray);

                    if(set.contains(replacedString)==true)
                    {
                        set.remove(replacedString);
                        q.offer(new Pair(replacedString,ans+1));
                    }
                }
            }
        }
        return 0;
    }
}