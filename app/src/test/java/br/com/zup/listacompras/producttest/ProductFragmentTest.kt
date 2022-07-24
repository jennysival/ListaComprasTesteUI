package br.com.zup.listacompras.producttest

import android.view.View
import android.widget.EditText
import org.junit.Test

class ProductFragmentTest {

    @Test
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