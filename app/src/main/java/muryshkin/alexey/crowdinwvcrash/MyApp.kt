package muryshkin.alexey.crowdinwvcrash

import android.app.Application
import com.crowdin.platform.Crowdin
import com.crowdin.platform.CrowdinConfig
import com.crowdin.platform.data.remote.NetworkType


class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Crowdin.init(
            applicationContext,
            CrowdinConfig.Builder()
                .withDistributionHash("d748670057aed2ef3f96389js96")
                .withNetworkType(NetworkType.ALL)
                .withUpdateInterval(900)
                .build()
        )
    }

}