package br.com.zup.listacompras.produto

import android.view.View
import android.widget.EditText
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProdutoFragmentTest{

    fun hasNoErrorText(): BoundedMatcher<View?, EditText> {
        return object : BoundedMatcher<View?, EditText>(EditText::class.java) {

            override fun matchesSafely(view: EditText): Boolean {
                return view.error == null
            }

            override fun describeTo(description: org.hamcrest.Description?) {
                description?.appendText("has no error text: ");
            }
        }
    }

}