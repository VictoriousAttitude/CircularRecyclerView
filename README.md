# Custom RecyclerView

Implementation of horizontal endless circular effect in RecyclerView: 
- Created custom doubly linked list
- Customized RecyclerView to get "endless circular effect" in both sides.

First solution "master" branch - is more preferrable, because I just reuse the same array there (3 times);

Second solution "second_branch" - is a dirty hack, because of using Integer.MAX_VALUE in the adapter.

If I find new proper ways to make circular endless effects - I will add them here

![circular effect](https://user-images.githubusercontent.com/11979084/38821395-107c2cd6-41a9-11e8-9908-39bfa76d54e8.png)
