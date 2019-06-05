package pls.help.launchdarkly

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.launchdarkly.android.LDClient
import com.launchdarkly.android.LDConfig
import com.launchdarkly.android.LDUser

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ldConfig = LDConfig.Builder().apply {
            setMobileKey("mob-7bf0fa17-06a6-4861-a038-c903fea2e47b")
        }.build()
        val user = LDUser.Builder("randomUser").apply {
            anonymous(false)
        }.build()
        val client =
            LDClient.init(
                application,
                ldConfig,
                user
            ).get()

        val beforeFlag = client.boolVariation("someFlag", false)
        Log.d("MainActivity", "Before: $beforeFlag")

        val changedUser = LDUser.Builder(user).apply {
            custom("customKey", System.currentTimeMillis())
        }.build()

        client.identify(changedUser).get()

        val afterFlag = client.boolVariation("someFlag", false)
        Log.d("MainActivity", "After: $afterFlag")
    }
}
