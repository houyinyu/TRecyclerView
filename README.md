# TRecyclerView<br/>

多类型item需求,来源于网友 SelfZhangTQ  非本人源码 <br/>
### 主要功能<br/>
   * 下拉刷新、加载更多；<br/>
   * 自定义下拉动画；<br/>
   * 高复用,支持多类型；<br/>
   * ...<br/>
   项目github地址:<https://github.com/houyinyu/TRecyclerView> <br/>



#### 使用步骤 <br/>
  Gradle<br/>
 Step 1. 在你的根build.gradle文件中增加JitPack仓库依赖。

     allprojects {
         repositories {
          jcenter()
          maven { url "https://jitpack.io" }
        }
     }

 Step 2. 在你的model的build.gradle文件中增加TRecyclerView依赖<br/>

     com.github.houyinyu:TRecyclerView:2.5.4



 Step 3. Item类型配置<br/>

    DelegateAdapter adapter = new DelegateAdapter.Builder<>()
            //设置刷新头 如果有刷新需求，此代码不配置，则不具有刷新功能，ProgressStyle.Pacman配置刷新样式
           .bind(HeaderVo.class, new HeaderViewHolder(this, ProgressStyle.Pacman));
            //设置item1，
           .bind(Bean1.class, new ItemView1(this))
           //设置item2，
           .bind(Bean2.class, new ItemView2(this))
           //加载更多，如果不需要加载更多，此代码可不配置
           .bind(FootVo.class, new FootViewHolder(this, ProgressStyle.Pacman))
            //一对多
          .bindArray(ItemData.class, new ItemHolder4(this), new ItemType5(this),new ItemHolder6(this))
          .withClass(new OneToMany<ItemData>() {
                  @Override
                  public Class<? extends VHolder<ItemData, ?>> onItemView(int position, ItemData itemData) {
                      if (itemData.type==1) {
                          return ItemHolder4.class;
                      }else if (itemData.type==2) {
                          return ItemHolder5.class;
                      }else if (itemData.type==3) {
                          return ItemHolder6.class;
                      }
                      return ItemHolder4.class;
                  }
              })
           .build();
    
    //数据容器
    items = new Items();

    layoutManager = new LinearLayoutManager(LinearLayoutActivity.this);
    mRecyclerView.setAdapter(adapter);
    mRecyclerView.setLayoutManager(layoutManager);


 Step 4. 自定义刷新动画配置和加载更多描述配置<br/>
       
      //自定义刷新头 需要实现OnTouchMoveListener接口，
      RefreshHeader refreshHeader = new RefreshHeader(this);
     .bind(HeaderVo.class,newHeaderViewHolder(LinearLayoutActivity.this,refreshHeader, new refreshHeader.getOnTouchMoveListener()))
                
                
    //加载更多描述配置，用4个参数的构造方法即可。
    new FootViewHolder(this, ProgressStyle.SysProgress,"努力加载","没有更多啦。。")；          

 Step 5.下拉刷新,加载更多,滚动监听回调<br/>

    mRecyclerView.addOnRefreshListener(new OnRefreshListener(){
            @Override
            public void onRefresh() {

             }
            @Override
            public void onLoadMore() {

            }
        });
    mRecyclerView.addOnTScrollListener(new OnTScrollListener() {
            @Override
            public void onScrolled(int dx, int dy) {

            }

            @Override
            public void onScrollStateChanged(int state) {

            }
        });

  Step 6.刷新完成或加载更多完成后的操作<br/>
   
    //刷新完成，有更多
    mRecyclerView.refreshComplete(items,false);
    
    //注：如果默认加载不够一页数,即没有更多
    mRecyclerView.refreshComplete(items,true);
   
    
    //加载更多完成，还有分页数据，
    //此处是服务器返回的数据集合，并非是所有数据集合
    mRecyclerView.loadMoreComplete(items,false);
    
    // 注：如果默认加载不够一页数,即没有更多
    mRecyclerView.refreshComplete(items,true);

    // 局部刷新
    mRecyclerView.notifyItemRangeChanged(position,1);


  Step 7. 添加Item点击事件

        adapter.setOnItemClickListener(this);//实现OnItemClickListener接口
        或者通过DelegateAdapter.Builder().setOnItemClickListener(this)配置
        
      <br/>

  Step 8.CoordinatorLayout+AppBarLayout+SwipeRecyclerView使用的问题<br/>
     
     由于滑动冲突，滑动到底部加载更多加载时间长问题，需要自定义AppBarLayout.Behavior
     
     <android.support.design.widget.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="top"
        app:elevation="0dp"
        app:layout_behavior="com.trecyclerview.util.AppBarBehavior">
     



