package cl.random.test.views

interface MainView
{

    // on create
    fun onReady()

    // progress
    fun showLoading()
    fun hideLoading()

    fun showCountries(total: Int);
}