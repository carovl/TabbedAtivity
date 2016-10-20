package app.caro.tabbedativity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class PagerAdapter  extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragmentLista tab0 = new TabFragmentLista(); //Lista de peliculas
                return tab0;
            case 1:
                TabFragment1 tab1 = new TabFragment1();
                return tab1;

            case 2:
                TabFragment3 tab3 = new TabFragment3(); //sinopsis
                return tab3;
            case 3:
                TabFragment2 tab2 = new TabFragment2(); //Horarios
                return tab2;


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}