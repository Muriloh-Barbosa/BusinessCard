package desktop.murilo.businesscard

import android.app.Application
import desktop.murilo.businesscard.data.AppDatabase
import desktop.murilo.businesscard.data.BusinessCardRepository

class App : Application() {
    private val database by lazy { AppDatabase.getDatabase(this) }
    val repository: BusinessCardRepository by lazy { BusinessCardRepository(database.businessDao()) }

}