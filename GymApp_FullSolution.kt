// ================================================================
//  GYM MEMBERSHIP REGISTRATION APP — FULL SOLUTION
//  Files needed:
//    1. activity_main.xml          → main booking form
//    2. activity_confirmation.xml  → shows submitted details
//    3. activity_help.xml          → opens from menu
//    4. res/menu/menu_main.xml     → three dot menu
//    5. MainActivity.kt            → main screen logic
//    6. ConfirmationActivity.kt    → confirmation screen logic
//    7. HelpActivity.kt            → help screen logic
//    8. AndroidManifest.xml        → register all activities
// ================================================================


// ════════════════════════════════════════════════════════════════
//  FILE 1 — res/layout/activity_main.xml
//  HOW TO USE: Open res/layout/activity_main.xml → delete all → paste
// ════════════════════════════════════════════════════════════════
/*
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="24dp">

        <!-- ── TOOLBAR: needed because theme is NoActionBar ──────
             Without this, three-dot menu will NOT appear.
             FROM: COMPANION_XML SECTION 17
             ALWAYS add as FIRST item inside LinearLayout          -->
        <androidx.appcompat.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:background="?attr/colorPrimary"
            android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"/>

        <!-- ── PAGE TITLE ──────────────────────────────────────── -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Gym Membership Registration"
            android:textSize="22sp"
            android:textStyle="bold"
            android:gravity="center"
            android:layout_marginTop="16dp"
            android:layout_marginBottom="24dp"/>

        <!-- ── NAME INPUT ───────────────────────────────────────
             FROM: COMPANION_XML SECTION 1
             etName → used in Kotlin as R.id.etName               -->
        <EditText
            android:id="@+id/etName"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Member Name"
            android:inputType="textPersonName"
            android:layout_marginBottom="16dp"/>

        <!-- ── PHONE INPUT ──────────────────────────────────────
             FROM: COMPANION_XML SECTION 1
             inputType="phone" shows number keyboard              -->
        <EditText
            android:id="@+id/etPhone"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Phone Number"
            android:inputType="phone"
            android:layout_marginBottom="16dp"/>

        <!-- ── SPINNER LABEL + SPINNER ─────────────────────────
             FROM: COMPANION_XML SECTION 2
             spinnerPlan → populated in Kotlin with ArrayAdapter  -->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Select Membership Plan"
            android:layout_marginBottom="4dp"/>
        <Spinner
            android:id="@+id/spinnerPlan"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="16dp"/>

        <!-- ── DATE PICKER BUTTON + DISPLAY ────────────────────
             FROM: COMPANION_XML SECTION 2
             btnPickDate → click opens DatePickerDialog
             tvDate      → shows selected date after picking      -->
        <Button
            android:id="@+id/btnPickDate"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Select Start Date"
            android:layout_marginBottom="8dp"/>
        <TextView
            android:id="@+id/tvDate"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="No date selected"
            android:layout_marginBottom="16dp"/>

        <!-- ── TOGGLE BUTTON ────────────────────────────────────
             FROM: COMPANION_XML SECTION 2
             textOn/textOff = what shows in each state
             toggleBtn.isChecked → true = Online, false = Offline  -->
        <ToggleButton
            android:id="@+id/toggleBtn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textOn="Online"
            android:textOff="Offline"
            android:layout_marginBottom="24dp"/>

        <!-- ── SUBMIT BUTTON ────────────────────────────────────
             FROM: COMPANION_XML SECTION 2
             Click → validate → go to ConfirmationActivity        -->
        <Button
            android:id="@+id/btnSubmit"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="SUBMIT"
            android:textStyle="bold"/>

    </LinearLayout>
</ScrollView>
*/


// ════════════════════════════════════════════════════════════════
//  FILE 2 — res/layout/activity_confirmation.xml
//  HOW TO USE: Right click res/layout → New → Layout Resource File
//              Name: activity_confirmation → delete all → paste
// ════════════════════════════════════════════════════════════════
/*
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="32dp">

    <!-- ── CONFIRMATION TITLE ────────────────────────────────── -->
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Membership Confirmed!"
        android:textSize="24sp"
        android:textStyle="bold"
        android:gravity="center"
        android:layout_marginBottom="32dp"/>

    <!-- ── DETAILS CARD ─────────────────────────────────────────
         FROM: COMPANION_XML SECTION 3
         Each TextView gets its text set in ConfirmationActivity  -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:background="#F5F5F5"
        android:padding="20dp"
        android:layout_marginBottom="32dp">

        <!-- tvConfirmName → set to "Name: <value>" in Kotlin     -->
        <TextView
            android:id="@+id/tvConfirmName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="16sp"
            android:layout_marginBottom="12dp"/>

        <!-- tvConfirmPhone → set to "Phone: <value>" in Kotlin   -->
        <TextView
            android:id="@+id/tvConfirmPhone"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="16sp"
            android:layout_marginBottom="12dp"/>

        <!-- tvConfirmPlan → set to "Plan: <value>" in Kotlin     -->
        <TextView
            android:id="@+id/tvConfirmPlan"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="16sp"
            android:layout_marginBottom="12dp"/>

        <!-- tvConfirmDate → set to "Start Date: <value>"         -->
        <TextView
            android:id="@+id/tvConfirmDate"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="16sp"
            android:layout_marginBottom="12dp"/>

        <!-- tvConfirmPayment → set to "Payment: <value>"         -->
        <TextView
            android:id="@+id/tvConfirmPayment"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="16sp"/>

    </LinearLayout>

    <!-- ── BACK BUTTON ──────────────────────────────────────────
         FROM: COMPANION_XML SECTION 3
         finish() → closes this activity → returns to Main        -->
    <Button
        android:id="@+id/btnBack"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="BACK"/>

</LinearLayout>
*/


// ════════════════════════════════════════════════════════════════
//  FILE 3 — res/layout/activity_help.xml
//  HOW TO USE: Right click res/layout → New → Layout Resource File
//              Name: activity_help → delete all → paste
//  THIS IS THE "MENU OPENS NEW PAGE" SCREEN
// ════════════════════════════════════════════════════════════════
/*
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="32dp">

    <!-- ── HELP TITLE ────────────────────────────────────────── -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Help &amp; Support"
        android:textSize="24sp"
        android:textStyle="bold"
        android:gravity="center"
        android:layout_marginBottom="32dp"/>

    <!-- ── HELP CONTENT ─────────────────────────────────────── -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Contact us at: gym@example.com"
        android:textSize="16sp"
        android:layout_marginBottom="12dp"/>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Phone: +91 9876543210"
        android:textSize="16sp"
        android:layout_marginBottom="12dp"/>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Timings: 6:00 AM - 10:00 PM"
        android:textSize="16sp"
        android:layout_marginBottom="32dp"/>

    <!-- ── BACK BUTTON ──────────────────────────────────────────
         Same as confirmation page — finish() goes back to Main   -->
    <Button
        android:id="@+id/btnBackHelp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="BACK"/>

</LinearLayout>
*/


// ════════════════════════════════════════════════════════════════
//  FILE 4 — res/menu/menu_main.xml
//  HOW TO USE:
//    1. Right click res → New → Android Resource Directory
//    2. Resource type → menu → OK
//    3. Right click menu folder → New → Menu Resource File
//    4. Name: menu_main → delete all → paste
// ════════════════════════════════════════════════════════════════
/*
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <!-- ── REFRESH: resets the form ────────────────────────────
         showAsAction="never" → always in three-dot overflow menu -->
    <item
        android:id="@+id/menu_refresh"
        android:title="Refresh"
        app:showAsAction="never"/>

    <!-- ── HELP: opens HelpActivity (new page!) ─────────────── -->
    <item
        android:id="@+id/menu_help"
        android:title="Help"
        app:showAsAction="never"/>

</menu>
*/


// ════════════════════════════════════════════════════════════════
//  FILE 5 — MainActivity.kt
//  HOW TO USE: Open MainActivity.kt → delete all → paste
//              Change package name on line 1 to match your project
// ════════════════════════════════════════════════════════════════

package com.example.myapplication          // ← CHANGE THIS to your package name

import android.app.DatePickerDialog
import android.content.Intent              // ← needed for going to next page
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    // Stores the date string selected by user
    // Declared here (not inside onCreate) so resetForm() can also access it
    private var selectedDate = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ── TOOLBAR SETUP ────────────────────────────────────────
        // FROM: SECTION 6B in cheatsheet
        // Required because theme is NoActionBar — without this line
        // the three-dot menu will NEVER appear on screen
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        // ── WIRE UP ALL VIEWS ────────────────────────────────────
        // findViewById connects Kotlin variable to the XML element
        // The id inside R.id.__ must match android:id in XML exactly
        val etName    = findViewById<EditText>(R.id.etName)
        val etPhone   = findViewById<EditText>(R.id.etPhone)
        val spinner   = findViewById<Spinner>(R.id.spinnerPlan)
        val btnDate   = findViewById<Button>(R.id.btnPickDate)
        val tvDate    = findViewById<TextView>(R.id.tvDate)
        val toggleBtn = findViewById<ToggleButton>(R.id.toggleBtn)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        // ── SPINNER SETUP ────────────────────────────────────────
        // FROM: SECTION 5A in cheatsheet
        // Step 1: define options (first item = placeholder)
        val plans = arrayOf("Select Plan", "Basic", "Standard", "Premium", "Annual")

        // Step 2: create adapter — converts array into spinner format
        val spinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,   // default item style
            plans
        )
        // Step 3: set dropdown style (required for dropdown to open properly)
        spinnerAdapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        // Step 4: attach adapter to spinner
        spinner.adapter = spinnerAdapter

        // ── DATE PICKER ──────────────────────────────────────────
        // FROM: SECTION 5B in cheatsheet
        // Opens calendar dialog when button is clicked
        btnDate.setOnClickListener {
            val cal = Calendar.getInstance()        // gets today's date
            DatePickerDialog(
                this,
                { _, year, month, day ->
                    // month+1 because Android months are 0-indexed (Jan=0)
                    selectedDate = "$day/${month + 1}/$year"
                    tvDate.text = "Date: $selectedDate"   // show on screen
                },
                cal.get(Calendar.YEAR),             // default = current year
                cal.get(Calendar.MONTH),            // default = current month
                cal.get(Calendar.DAY_OF_MONTH)      // default = current day
            ).show()                                // .show() opens the dialog
        }

        // ── SUBMIT BUTTON ────────────────────────────────────────
        // FROM: SECTION 5D + EXTRAS in cheatsheet
        btnSubmit.setOnClickListener {

            // Read all values from the form
            val name    = etName.text.toString().trim()   // trim() removes spaces
            val phone   = etPhone.text.toString().trim()
            val plan    = spinner.selectedItem.toString()
            // isChecked = true → textOn shown ("Online"), false → textOff ("Offline")
            val payment = if (toggleBtn.isChecked) "Online" else "Offline"

            // ── VALIDATION ───────────────────────────────────────
            // FROM: SECTION EXTRAS in cheatsheet
            // .error shows red error message below the EditText
            // return@setOnClickListener stops the rest of the code from running
            if (name.isEmpty()) {
                etName.error = "Please enter member name"
                return@setOnClickListener
            }
            if (phone.isEmpty()) {
                etPhone.error = "Please enter phone number"
                return@setOnClickListener
            }
            // Spinner validation: check if still on placeholder
            if (plan == "Select Plan") {
                Toast.makeText(this, "Please select a plan", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Date validation: check if date was picked
            if (selectedDate.isEmpty()) {
                Toast.makeText(this, "Please select a start date", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // ── GO TO NEXT PAGE (ConfirmationActivity) ───────────
            // FROM: SECTION 2B in cheatsheet
            // Intent = the "message" that tells Android which Activity to open
            val intent = Intent(this, ConfirmationActivity::class.java)

            // putExtra = attach data to the intent as key-value pairs
            // KEY must exactly match what ConfirmationActivity uses to receive
            intent.putExtra("NAME",    name)
            intent.putExtra("PHONE",   phone)
            intent.putExtra("PLAN",    plan)
            intent.putExtra("DATE",    selectedDate)
            intent.putExtra("PAYMENT", payment)

            // startActivity = actually launches the new screen
            startActivity(intent)
        }
    }

    // ── THREE DOT MENU — INFLATE ─────────────────────────────────
    // FROM: SECTION 6 in cheatsheet
    // This method is called automatically by Android to build the menu
    // menuInflater.inflate connects menu_main.xml to this activity
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true    // must return true otherwise menu won't show
    }

    // ── THREE DOT MENU — HANDLE CLICKS ──────────────────────────
    // FROM: SECTION 6 in cheatsheet
    // Called automatically when user taps any menu item
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            // ── REFRESH: reset the form ──────────────────────────
            R.id.menu_refresh -> {
                resetForm()
                Toast.makeText(this, "Form Reset!", Toast.LENGTH_SHORT).show()
                true    // must return true to say "we handled this click"
            }

            // ── HELP: open HelpActivity (NEW PAGE from menu!) ────
            // FROM: SECTION 2B in cheatsheet — same Intent pattern
            // KEY DIFFERENCE from hospital app: instead of Toast,
            // we use Intent to open a completely new Activity
            R.id.menu_help -> {
                val intent = Intent(this, HelpActivity::class.java)
                // No putExtra needed — Help page has no dynamic data
                startActivity(intent)   // ← THIS is what opens the new page
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    // ── RESET FORM HELPER ────────────────────────────────────────
    // FROM: SECTION 5D in cheatsheet
    // Called by menu_refresh click above
    private fun resetForm() {
        findViewById<EditText>(R.id.etName).text.clear()
        findViewById<EditText>(R.id.etPhone).text.clear()
        findViewById<Spinner>(R.id.spinnerPlan).setSelection(0)   // back to placeholder
        selectedDate = ""
        findViewById<TextView>(R.id.tvDate).text = "No date selected"
        findViewById<ToggleButton>(R.id.toggleBtn).isChecked = false
    }
}


// ════════════════════════════════════════════════════════════════
//  FILE 6 — ConfirmationActivity.kt
//  HOW TO USE:
//    Right click package → New → Kotlin Class
//    Name: ConfirmationActivity → delete all → paste
// ════════════════════════════════════════════════════════════════

class ConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        // ── RECEIVE DATA FROM MAIN ───────────────────────────────
        // FROM: SECTION 2B in cheatsheet
        // intent.getStringExtra("KEY") → reads what MainActivity sent
        // KEY must EXACTLY match what was used in putExtra()
        // ?: "" means: if null, use empty string as default
        val name    = intent.getStringExtra("NAME")    ?: ""
        val phone   = intent.getStringExtra("PHONE")   ?: ""
        val plan    = intent.getStringExtra("PLAN")    ?: ""
        val date    = intent.getStringExtra("DATE")    ?: ""
        val payment = intent.getStringExtra("PAYMENT") ?: ""

        // ── DISPLAY DATA IN TEXTVIEWS ────────────────────────────
        // FROM: SECTION 2B in cheatsheet
        // Set text of each TextView to show the received values
        findViewById<TextView>(R.id.tvConfirmName).text    = "Name    : $name"
        findViewById<TextView>(R.id.tvConfirmPhone).text   = "Phone   : $phone"
        findViewById<TextView>(R.id.tvConfirmPlan).text    = "Plan    : $plan"
        findViewById<TextView>(R.id.tvConfirmDate).text    = "Start   : $date"
        findViewById<TextView>(R.id.tvConfirmPayment).text = "Payment : $payment"

        // ── BACK BUTTON ──────────────────────────────────────────
        // FROM: SECTION EXTRAS in cheatsheet
        // finish() = close THIS activity = return to previous screen
        // DO NOT use startActivity(Intent(...MainActivity...)) here!
        // That would create a brand new MainActivity instead of going back
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()    // ← THIS is the back button magic
        }
    }
}


// ════════════════════════════════════════════════════════════════
//  FILE 7 — HelpActivity.kt
//  HOW TO USE:
//    Right click package → New → Kotlin Class
//    Name: HelpActivity → delete all → paste
//  THIS IS THE NEW PAGE THAT OPENS FROM THE MENU
// ════════════════════════════════════════════════════════════════

class HelpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        // ── BACK BUTTON ──────────────────────────────────────────
        // Same as ConfirmationActivity — finish() goes back to Main
        // No data to receive here — Help page is static content
        findViewById<Button>(R.id.btnBackHelp).setOnClickListener {
            finish()    // closes HelpActivity → returns to MainActivity
        }
    }
}


// ════════════════════════════════════════════════════════════════
//  FILE 8 — AndroidManifest.xml (ADD these two lines only)
//  HOW TO USE:
//    Open manifests/AndroidManifest.xml
//    Find the <application> block
//    Add BOTH lines below AFTER the MainActivity block
// ════════════════════════════════════════════════════════════════
/*
<!-- ADD BOTH LINES inside <application> block -->
<activity android:name=".ConfirmationActivity" android:exported="false"/>
<activity android:name=".HelpActivity" android:exported="false"/>

<!-- If you forget either line → app crashes when going to that screen -->
*/


// ════════════════════════════════════════════════════════════════
//  QUICK REFERENCE — What does what
// ════════════════════════════════════════════════════════════════
/*
TOOLBAR (shows menu dots):
  XML:    <androidx.appcompat.widget.Toolbar android:id="@+id/toolbar" .../>
  Kotlin: setSupportActionBar(findViewById(R.id.toolbar))
  Why:    Theme is NoActionBar → need manual toolbar

THREE DOT MENU:
  XML:    res/menu/menu_main.xml  → defines menu items
  Kotlin: onCreateOptionsMenu()  → inflates the XML
          onOptionsItemSelected() → handles clicks

GO TO NEXT PAGE:
  val intent = Intent(this, TargetActivity::class.java)
  intent.putExtra("KEY", value)   → attach data
  startActivity(intent)           → open the page

RECEIVE DATA ON NEXT PAGE:
  val value = intent.getStringExtra("KEY") ?: ""

BACK BUTTON:
  btnBack.setOnClickListener { finish() }
  finish() = close current activity = go back automatically

RESET FORM:
  editText.text.clear()
  spinner.setSelection(0)
  toggleBtn.isChecked = false
  selectedDate = ""

VALIDATION:
  editText.error = "message"      → red error under field
  return@setOnClickListener       → stop rest of code
  spinner == "placeholder"        → check if nothing selected
  selectedDate.isEmpty()          → check if date not picked
*/
