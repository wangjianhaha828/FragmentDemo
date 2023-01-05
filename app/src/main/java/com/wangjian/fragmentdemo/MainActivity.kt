package com.wangjian.fragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.wangjian.fragmentdemo.fragment.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button1).setOnClickListener{
            switchFragment(SecondFragment.newInstance())
        }
        findViewById<Button>(R.id.button2).setOnClickListener{
            switchFragment(ThreeFragment.newInstance())
        }
        findViewById<Button>(R.id.button3).setOnClickListener{
            switchFragment(FourFragment.newInstance())
        }
        findViewById<Button>(R.id.button4).setOnClickListener{
            supportFragmentManager?.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE)
            switchFragment(SecondFragment.newInstance())
        }
        findViewById<Button>(R.id.button5).setOnClickListener{
            supportFragmentManager?.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE)
            switchFragment(FirstFragment.newInstance())
        }
        findViewById<Button>(R.id.button6).setOnClickListener{
            supportFragmentManager?.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
        addFragment(FirstFragment.newInstance(),false)
    }

    //切换fragment,并添加到backStack
    private fun switchFragment(fragment: Fragment,loss: Boolean = true) {
        supportFragmentManager.beginTransaction().apply {
            addToBackStack("")
            replace(R.id.container,fragment,"")
//            commit()
            if (loss) commitAllowingStateLoss() else commit()
        }
    }

    //切换fragment,不添加到backStack
    private fun switchFragmentWithoutBack(fragment: Fragment,loss: Boolean = true) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container,fragment,"")
//            commit()
            if (loss) commitAllowingStateLoss() else commit()
        }
    }

    //添加fragment
    private fun addFragment(fragment: Fragment,loss: Boolean = true) {
        supportFragmentManager.beginTransaction().apply {
            add(0,fragment,"")
//            add(R.id.container,fragment)
//            commit()
            if (loss) commitAllowingStateLoss() else commit()
        }
    }
}