package net.liberr.monyacy

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.widget.*

class MainActivity : AppCompatActivity() {
    companion object {
        val STANDARD_TIMES = hashMapOf<String, Double>(
                "GMT" to 0.0,
                "UTC" to 0.0,
                "ECT" to 1.0,
                "EET" to 2.0,
                "ART" to 2.0,
                "EAT" to 3.0,
                "MET" to 3.5,
                "NET" to 4.0,
                "PLT" to 5.0,
                "IST" to 5.5,
                "BST" to 6.0,
                "VST" to 7.0,
                "CTT" to 8.0,
                "JST" to 9.0,
                "ACT" to 9.5,
                "AET" to 10.0,
                "SST" to 11.0,
                "NST" to 12.0,
                "MIT" to -11.0,
                "HST" to -10.0,
                "AST" to -9.0,
                "PST" to -8.0,
                "PNT" to -7.0,
                "MST" to -7.0,
                "CST" to -6.0,
                "EST" to -5.0,
                "IET" to -5.0,
                "PRT" to -4.0,
                "CNT" to -3.5,
                "AGT" to -3.0,
                "BET" to -3.0,
                "CAT" to -1.0
        )
    }

    val eventTitle by lazy {
        findViewById(R.id.eventTitle) as EditText
    }

    val eventTime by lazy {
        findViewById(R.id.eventTime) as TextClock
    }

    val eventDate by lazy {
        findViewById(R.id.eventDate) as CalendarView
    }

    val fixLocale by lazy {
        findViewById(R.id.fixLocale) as Spinner
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            // TODO: Send intent for google calendar
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val sharingText = intent.extras.getCharSequence(Intent.EXTRA_TEXT)

        val timeLike = Regex("""(\d{1,2})\s*:?\s*(\d{2})""").matchEntire(sharingText)
        val localeLike = Regex("""([A-V][A-T][CT])""").matchEntire(sharingText)
        val noonLike = Regex("""([ap]m)""", RegexOption.IGNORE_CASE).matchEntire(sharingText)?.value

        if (noonLike != null) {

        }
        eventTime.format24Hour = null;
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
