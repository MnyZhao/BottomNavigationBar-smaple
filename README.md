# BottomNavigationBar-smaple
   
- 去除文字动画
    --
    >通过设置选中前和选中后的字体大小 可以在dimens.xml文件中使用它:
    `<dimen name="design_bottom_navigation_active_text_size">14dp</dimen>
            <dimen name="design_bottom_navigation_text_size">14dp</dimen>   
    `
- 设置icon的margin
    在dimens
    <
- 当出现3个以上menu的时候取消浮夸的动画效果
    --
    ```java 
     在之前的版本上（28之前）
     public  void disableShiftMode(BottomNavigationView view) {
            BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
            try {
                Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
                shiftingMode.setAccessible(true);
                shiftingMode.setBoolean(menuView, false);
                shiftingMode.setAccessible(false);
                for (int i = 0; i < menuView.getChildCount(); i++) {
                    BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                    item.setShiftingMode(false);
                    item.setChecked(item.getItemData().isChecked());
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    ```
    api 28则做出了改变
    --
    >可以使用app:labelVisibilityMode="[labeled, unlabeled, selected, auto]"了28-alpha
     
     labeled 将保持所有标签可见。
     unlabeled 将只显示图标。
     selected 将仅显示所选项目的标签和班次项目。
     auto将根据您拥有的物品数量选择标记或选择。标记为1-3项，并选择3项以上。
   