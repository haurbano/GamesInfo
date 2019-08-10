package innovappte.mobile.gamesinfo.mainscreen

interface MainActivityContract {
    interface View {
        fun fillFragments()
    }

    interface Presenter {
        fun fillFragments()
        fun attachView(view: View)
    }
}