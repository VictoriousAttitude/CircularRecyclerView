# Custom RecyclerView

Implementation of horizontal endless circular effect in RecyclerView: 
- Created custom doubly linked list
- Customized RecyclerView to get "endless circular effect" in both sides.

First solution "master" branch - is more preferrable, because I just reuse the same array there (3 times);

Second solution "second_branch" - is a dirty hack, because of using Integer.MAX_VALUE in the adapter.

If I find new proper ways to make circular endless effects - I will add them here

[![Circular_Recycler_View.png](https://s19.postimg.org/9qfuj7d3n/Circular_Recycler_View.png)](https://postimg.org/image/7943bxt73/)
