package br.com.zup.listacompras.produto

import android.view.View
import android.widget.EditText
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import br.com.zup.listacompras.R

@RunWith(AndroidJUnit4::class)
class ProdutoFragmentTest{

    @Test
    fun showErrorWhenEditTextsAreEmpty(){
        val scenario = launchFragmentInContainer<ProdutoFragment>()

        onView(withId(R.id.bvAdicionar)).perform(click())

        onView(withId(R.id.etNomeProduto))
            .check(matches(hasErrorText("Por favor preencha o campo de nome")))

        onView(withId(R.id.etDetalheProduto))
            .check(matches(hasErrorText("Por favor preencha o campo de detalhe")))
    }

    @Test
    fun showErrorWhenOnlyEditTextDetalheIsEmpty(){
        val scenario = launchFragmentInContainer<ProdutoFragment>()
        onView(withId(R.id.etNomeProduto)).perform(typeText("Alguma coisa"))
        onView(withId(R.id.bvAdicionar)).perform(click())

        onView(withId(R.id.etDetalheProduto))
            .check(matches(hasErrorText("Por favor preencha o campo de detalhe")))

        onView(withId(R.id.etNomeProduto))
            .check(matches(hasNoErrorText()))
    }

    @Test
    fun showErrorWhenOnlyEditTextNomeIsEmpty(){
        val scenario = launchFragmentInContainer<ProdutoFragment>()
        onView(withId(R.id.etDetalheProduto)).perform(typeText("Alguma coisa"))
        onView(withId(R.id.bvAdicionar)).perform(click())

        onView(withId(R.id.etNomeProduto))
            .check(matches(hasErrorText("Por favor preencha o campo de nome")))

        onView(withId(R.id.etDetalheProduto))
            .check(matches(hasNoErrorText()))
    }

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