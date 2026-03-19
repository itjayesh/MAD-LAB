// ============================================================
//  MAD LAB – KOTLIN CHEAT SHEET  (ICT 3268)
//  HOW TO USE:
//  1. Find the section you need (Ctrl+F the section name)
//  2. Copy the relevant Activity class OR the XML snippet
//  3. Paste into Android Studio, rename class/IDs as needed
//  4. Check the "BOILERPLATE" section at the top first —
//     every app needs that foundation
// ============================================================


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 0 — BOILERPLATE (ALWAYS NEEDED)               ║
// ║  Every app needs: build.gradle deps + Manifest entry   ║
// ╚══════════════════════════════════════════════════════════╝

/*
── build.gradle (Module: app) → dependencies block ──────────
dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}

── AndroidManifest.xml — register EVERY activity you create ──
<activity android:name=".YourActivityName" />

── For URL/Browser intent add this permission ────────────────
<uses-permission android:name="android.permission.INTERNET"/>

── For reading installed apps ────────────────────────────────
<uses-permission android:name="android.permission.QUERY_ALL_PACKAGES"
    tools:ignore="QueryAllPackagesPermission"/>
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 1 — LAB 1: BASICS (TextView, Hello World)     ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_main.xml ─────────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    android:gravity="center">

    <TextView
        android:id="@+id/tvHello"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello, Android!"
        android:textSize="24sp"
        android:textColor="#6200EE"
        android:textStyle="bold"
        android:gravity="center"
        android:fontFamily="serif"
        android:justificationMode="inter_word"
        android:padding="8dp"/>

</LinearLayout>
*/

import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Lab1_BasicsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Modify TextView from code (optional — XML is enough for Lab1)
        val tv = findViewById<TextView>(R.id.tvHello)
        tv.text = "Hello, Android!"
        tv.setTextColor(Color.parseColor("#6200EE"))
        tv.textSize = 24f
        tv.setTypeface(null, Typeface.BOLD)
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 2 — LAB 2A: ACTIVITY LIFECYCLE                ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_lifecycle.xml ────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:id="@+id/tvLog"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Lifecycle events will show here"
        android:textSize="16sp"
        android:padding="8dp"/>

</LinearLayout>
*/

import android.util.Log
import android.widget.Toast

class Lab2A_LifecycleActivity : AppCompatActivity() {
    private val TAG = "LifecycleDemo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        log("onCreate called")
    }
    override fun onStart()   { super.onStart();   log("onStart called") }
    override fun onResume()  { super.onResume();  log("onResume called") }
    override fun onPause()   { super.onPause();   log("onPause called") }
    override fun onStop()    { super.onStop();    log("onStop called") }
    override fun onDestroy() { super.onDestroy(); log("onDestroy called") }

    private fun log(msg: String) {
        Log.d(TAG, msg)
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        // Also update TextView if needed:
        // findViewById<TextView>(R.id.tvLog).append("\n$msg")
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 2B — LAB 2: CALCULATOR APP (2 Activities)     ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_calculator.xml ───────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="24dp"
    android:gravity="center">

    <EditText android:id="@+id/etNum1"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Enter Number 1" android:inputType="numberDecimal"
        android:layout_marginBottom="12dp"/>

    <EditText android:id="@+id/etNum2"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Enter Number 2" android:inputType="numberDecimal"
        android:layout_marginBottom="16dp"/>

    <LinearLayout android:layout_width="match_parent"
        android:layout_height="wrap_content" android:orientation="horizontal"
        android:gravity="center" android:layout_marginBottom="16dp">
        <Button android:id="@+id/btnAdd"  android:layout_width="0dp"
            android:layout_height="wrap_content" android:layout_weight="1"
            android:text="+" android:layout_margin="4dp"/>
        <Button android:id="@+id/btnSub"  android:layout_width="0dp"
            android:layout_height="wrap_content" android:layout_weight="1"
            android:text="-" android:layout_margin="4dp"/>
        <Button android:id="@+id/btnMul"  android:layout_width="0dp"
            android:layout_height="wrap_content" android:layout_weight="1"
            android:text="×" android:layout_margin="4dp"/>
        <Button android:id="@+id/btnDiv"  android:layout_width="0dp"
            android:layout_height="wrap_content" android:layout_weight="1"
            android:text="÷" android:layout_margin="4dp"/>
    </LinearLayout>

</LinearLayout>

── activity_result.xml ───────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="24dp">

    <TextView android:id="@+id/tvResult"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textSize="28sp" android:textStyle="bold"
        android:gravity="center" android:layout_marginBottom="24dp"/>

    <Button android:id="@+id/btnBack"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Back to Calculator"/>
</LinearLayout>
*/

import android.content.Intent
import android.widget.Button
import android.widget.EditText

class Lab2B_CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val etNum1 = findViewById<EditText>(R.id.etNum1)
        val etNum2 = findViewById<EditText>(R.id.etNum2)

        fun calculate(op: String) {
            val n1 = etNum1.text.toString().toDoubleOrNull() ?: return
            val n2 = etNum2.text.toString().toDoubleOrNull() ?: return
            val result = when (op) {
                "+" -> n1 + n2
                "-" -> n1 - n2
                "×" -> n1 * n2
                "÷" -> if (n2 != 0.0) n1 / n2 else Double.NaN
                else -> 0.0
            }
            // Format: "Num1 op Num2 = Result"
            val display = "$n1 $op $n2 = $result"
            val intent = Intent(this, Lab2B_ResultActivity::class.java)
            intent.putExtra("RESULT", display)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnAdd).setOnClickListener { calculate("+") }
        findViewById<Button>(R.id.btnSub).setOnClickListener { calculate("-") }
        findViewById<Button>(R.id.btnMul).setOnClickListener { calculate("×") }
        findViewById<Button>(R.id.btnDiv).setOnClickListener { calculate("÷") }
    }
}

class Lab2B_ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val result = intent.getStringExtra("RESULT") ?: "No result"
        findViewById<TextView>(R.id.tvResult).text = result
        // Back button goes back to calculator (finishes this activity)
        findViewById<Button>(R.id.btnBack).setOnClickListener { finish() }
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 2C — LAB 2: OPEN URL (Implicit Intent)        ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_url.xml ──────────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="24dp" android:gravity="center">

    <EditText android:id="@+id/etUrl"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Enter URL (e.g. https://google.com)"
        android:inputType="textUri"
        android:layout_marginBottom="16dp"/>

    <Button android:id="@+id/btnOpen"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Open URL"/>
</LinearLayout>
*/

import android.net.Uri
import android.widget.EditText

class Lab2C_UrlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_url)

        val etUrl = findViewById<EditText>(R.id.etUrl)
        findViewById<Button>(R.id.btnOpen).setOnClickListener {
            var url = etUrl.text.toString().trim()
            if (!url.startsWith("http")) url = "https://$url"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 3A — LAB 3: LIST VIEW                         ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_listview.xml ─────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical">

    <ListView android:id="@+id/listView"
        android:layout_width="match_parent" android:layout_height="match_parent"/>
</LinearLayout>
*/

import android.widget.ArrayAdapter
import android.widget.ListView

class Lab3A_ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        val sports = arrayOf("Cricket", "Football", "Tennis", "Hockey", "Basketball", "Volleyball")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sports)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Selected: ${sports[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 3B — LAB 3: GRID VIEW                         ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_gridview.xml ─────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<GridView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/gridView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:numColumns="3"
    android:columnWidth="100dp"
    android:stretchMode="columnWidth"
    android:gravity="center"
    android:padding="8dp"/>
*/

import android.widget.GridView

class Lab3B_GridViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gridview)

        val items = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        val gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Clicked: ${items[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 3C — LAB 3: TAB LAYOUT + VIEWPAGER            ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_tabs.xml ─────────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical">

    <com.google.android.material.tabs.TabLayout
        android:id="@+id/tabLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:tabMode="fixed"
        app:tabGravity="fill"/>

    <androidx.viewpager2.widget.ViewPager2
        android:id="@+id/viewPager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
</LinearLayout>

── fragment_tab.xml ──────────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:gravity="center">
    <TextView android:id="@+id/tvTabContent"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textSize="20sp"/>
</LinearLayout>
*/

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

// ── Tab Fragment ──────────────────────────────────────────────
class TabFragment(private val content: String) : Fragment(R.layout.fragment_tab) {
    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.tvTabContent).text = content
    }
}

// ── Tab Adapter ───────────────────────────────────────────────
class TabAdapter(activity: FragmentActivity, private val tabs: List<Pair<String, String>>) :
    FragmentStateAdapter(activity) {
    override fun getItemCount() = tabs.size
    override fun createFragment(position: Int) = TabFragment(tabs[position].second)
}

// ── Main Activity ─────────────────────────────────────────────
class Lab3C_TabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)

        // Change tab names and content here
        val tabs = listOf(
            "Top Stories" to "Top Stories content here",
            "Sports"      to "Sports content here",
            "Entertainment" to "Entertainment content here"
        )

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = TabAdapter(this, tabs)

        TabLayoutMediator(findViewById(R.id.tabLayout), viewPager) { tab, position ->
            tab.text = tabs[position].first
        }.attach()
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 4A — LAB 4: BUTTON + TOGGLEBUTTON + TOAST     ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_buttons.xml ──────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:gravity="center" android:padding="24dp">

    <Button android:id="@+id/btnNormal"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Click Me" android:layout_marginBottom="16dp"/>

    <ToggleButton android:id="@+id/toggleBtn"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textOn="Wi-Fi ON" android:textOff="Wi-Fi OFF"
        android:layout_marginBottom="16dp"/>

    <ImageView android:id="@+id/imgMode"
        android:layout_width="100dp" android:layout_height="100dp"
        android:src="@drawable/ic_launcher_foreground"/>

</LinearLayout>
*/

import android.widget.ImageView
import android.widget.ToggleButton

class Lab4A_ButtonsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttons)

        // Normal Button → Toast
        findViewById<Button>(R.id.btnNormal).setOnClickListener {
            Toast.makeText(this, "Button Clicked!", Toast.LENGTH_SHORT).show()
        }

        // Toggle Button → change image + toast
        val imgMode = findViewById<ImageView>(R.id.imgMode)
        findViewById<ToggleButton>(R.id.toggleBtn).setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Mode: Wi-Fi", Toast.LENGTH_SHORT).show()
                imgMode.setImageResource(android.R.drawable.ic_menu_share) // replace with your drawable
            } else {
                Toast.makeText(this, "Mode: Mobile Data", Toast.LENGTH_SHORT).show()
                imgMode.setImageResource(android.R.drawable.ic_menu_call) // replace with your drawable
            }
        }
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 4B — LAB 4: CHECKBOX + FOOD ORDER APP         ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_food.xml ─────────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="24dp">

    <CheckBox android:id="@+id/cbBurger"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Burger - ₹120" android:layout_marginBottom="8dp"/>
    <CheckBox android:id="@+id/cbPizza"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Pizza - ₹250" android:layout_marginBottom="8dp"/>
    <CheckBox android:id="@+id/cbFries"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Fries - ₹80" android:layout_marginBottom="16dp"/>

    <Button android:id="@+id/btnSubmit"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Submit Order"/>
</LinearLayout>

── activity_order_summary.xml ────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:gravity="center" android:padding="24dp">

    <TextView android:id="@+id/tvSummary"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textSize="18sp" android:layout_marginBottom="12dp"/>
    <TextView android:id="@+id/tvTotal"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textSize="22sp" android:textStyle="bold"/>
</LinearLayout>
*/

import android.widget.CheckBox

class Lab4B_FoodOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val cbBurger = findViewById<CheckBox>(R.id.cbBurger)
        val cbPizza  = findViewById<CheckBox>(R.id.cbPizza)
        val cbFries  = findViewById<CheckBox>(R.id.cbFries)
        val prices   = mapOf("Burger" to 120, "Pizza" to 250, "Fries" to 80)

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            val selected = mutableListOf<String>()
            var total = 0
            if (cbBurger.isChecked) { selected.add("Burger - ₹120"); total += 120 }
            if (cbPizza.isChecked)  { selected.add("Pizza - ₹250");  total += 250 }
            if (cbFries.isChecked)  { selected.add("Fries - ₹80");   total += 80  }

            // Lock checkboxes after submit
            cbBurger.isEnabled = false
            cbPizza.isEnabled  = false
            cbFries.isEnabled  = false

            val intent = Intent(this, Lab4B_OrderSummaryActivity::class.java)
            intent.putExtra("ITEMS", selected.joinToString("\n"))
            intent.putExtra("TOTAL", total)
            startActivity(intent)
        }
    }
}

class Lab4B_OrderSummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_summary)
        val items = intent.getStringExtra("ITEMS") ?: "No items"
        val total = intent.getIntExtra("TOTAL", 0)
        findViewById<TextView>(R.id.tvSummary).text = "Order:\n$items"
        findViewById<TextView>(R.id.tvTotal).text   = "Total: ₹$total"
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 4C — LAB 4: RADIO BUTTON + RADIO GROUP        ║
// ║  Use when: single choice from a list (gender, plan etc) ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_radio.xml ────────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="24dp"
    android:gravity="center">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Select Plan"
        android:textSize="18sp"
        android:textStyle="bold"
        android:layout_marginBottom="16dp"/>

    <!-- RadioGroup ensures only ONE can be selected at a time -->
    <RadioGroup
        android:id="@+id/radioGroup"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:layout_marginBottom="24dp">

        <RadioButton
            android:id="@+id/rbBasic"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Basic Plan"
            android:layout_marginBottom="8dp"/>

        <RadioButton
            android:id="@+id/rbStandard"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Standard Plan"
            android:layout_marginBottom="8dp"/>

        <RadioButton
            android:id="@+id/rbPremium"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Premium Plan"/>

    </RadioGroup>

    <Button
        android:id="@+id/btnSubmit"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="SUBMIT"/>

    <TextView
        android:id="@+id/tvResult"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="16sp"
        android:layout_marginTop="16dp"/>

</LinearLayout>
*/

import android.widget.RadioButton
import android.widget.RadioGroup

class Lab4C_RadioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val tvResult   = findViewById<TextView>(R.id.tvResult)

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {

            // Step 1 — get the ID of the selected radio button
            val selectedId = radioGroup.checkedRadioButtonId

            // Step 2 — validate: nothing selected
            if (selectedId == -1) {
                Toast.makeText(this, "Please select a plan", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Step 3 — get the RadioButton using the ID, then read its text
            val selectedBtn = findViewById<RadioButton>(selectedId)
            val selectedText = selectedBtn.text.toString()

            tvResult.text = "You selected: $selectedText"
            Toast.makeText(this, "Selected: $selectedText", Toast.LENGTH_SHORT).show()
        }

        // OPTIONAL: detect change as user taps (without Submit button)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val btn = findViewById<RadioButton>(checkedId)
            // tvResult.text = "Changed to: ${btn.text}"
        }
    }
}

// ── Key facts to remember ─────────────────────────────────────
/*
RadioGroup.checkedRadioButtonId   → returns ID of selected button, -1 if none
findViewById<RadioButton>(id)     → get the actual button from its ID
radioBtn.text.toString()          → get the label text
radioGroup.clearCheck()           → deselect everything (for reset)
radioGroup.check(R.id.rbBasic)    → programmatically select one
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 4D — LAB 4: SEEKBAR                           ║
// ║  Use when: volume, brightness, rating, age range etc   ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_seekbar.xml ──────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="24dp"
    android:gravity="center">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Select Rating"
        android:textSize="18sp"
        android:textStyle="bold"
        android:layout_marginBottom="16dp"/>

    <SeekBar
        android:id="@+id/seekBar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:max="10"
        android:progress="5"
        android:layout_marginBottom="16dp"/>

    <!-- Shows current value live -->
    <TextView
        android:id="@+id/tvSeekValue"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Value: 5"
        android:textSize="18sp"
        android:layout_marginBottom="24dp"/>

    <Button
        android:id="@+id/btnSubmit"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="SUBMIT"/>

</LinearLayout>
*/

import android.widget.SeekBar

class Lab4D_SeekBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seekbar)

        val seekBar    = findViewById<SeekBar>(R.id.seekBar)
        val tvSeekValue = findViewById<TextView>(R.id.tvSeekValue)

        // Listen for changes as user drags
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            // Called CONTINUOUSLY as user drags the thumb
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
                tvSeekValue.text = "Value: $progress"
            }

            // Called when user STARTS dragging
            override fun onStartTrackingTouch(sb: SeekBar?) {
                // optional — leave empty if not needed
            }

            // Called when user RELEASES the thumb
            override fun onStopTrackingTouch(sb: SeekBar?) {
                Toast.makeText(this@Lab4D_SeekBarActivity,
                    "Final value: ${sb?.progress}", Toast.LENGTH_SHORT).show()
            }
        })

        // Get value on Submit button click
        findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            val value = seekBar.progress
            Toast.makeText(this, "Rating submitted: $value / ${seekBar.max}",
                Toast.LENGTH_SHORT).show()
        }
    }
}

// ── Key attributes in XML ─────────────────────────────────────
/*
android:max="10"        → maximum value (default 100)
android:progress="5"    → starting position
android:min="1"         → minimum value (API 26+)

seekBar.progress        → get current value in Kotlin
seekBar.max             → get max value
seekBar.progress = 0    → reset to 0 programmatically
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 5A — LAB 5: SPINNER                           ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_spinner.xml ──────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="24dp" android:gravity="center">

    <Spinner android:id="@+id/spinner"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:layout_marginBottom="16dp"/>

    <TextView android:id="@+id/tvSelected"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textSize="18sp"/>
</LinearLayout>
*/

import android.widget.AdapterView
import android.widget.Spinner

class Lab5A_SpinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        val items = arrayOf("Car", "Bike", "Truck", "Bus", "Auto")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, pos: Int, id: Long) {
                val selected = items[pos]
                findViewById<TextView>(R.id.tvSelected).text = "Selected: $selected"
                Toast.makeText(this@Lab5A_SpinnerActivity, "Selected: $selected", Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 5B — LAB 5: DATE PICKER                       ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_datepicker.xml ───────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:gravity="center" android:padding="24dp">

    <Button android:id="@+id/btnPickDate"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Pick Date" android:layout_marginBottom="16dp"/>

    <TextView android:id="@+id/tvDate"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textSize="20sp" android:text="No date selected"/>
</LinearLayout>
*/

import android.app.DatePickerDialog
import java.util.Calendar

class Lab5B_DatePickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datepicker)

        val tvDate = findViewById<TextView>(R.id.tvDate)

        findViewById<Button>(R.id.btnPickDate).setOnClickListener {
            val cal = Calendar.getInstance()
            DatePickerDialog(
                this,
                { _, year, month, day ->
                    val date = "$day/${month + 1}/$year"
                    tvDate.text = "Selected Date: $date"
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 5B-2 — DATE PICKER WITH MIN/MAX DATE LIMIT    ║
// ║  Use when: "only future dates" / "only next X days"    ║
// ║  "only past dates" / "date range restriction"          ║
// ╚══════════════════════════════════════════════════════════╝

/*
KEY RULES:
  "only future dates"       → set minDate = today only
  "only next 20 days"       → set minDate = today AND maxDate = today + 20
  "only past dates"         → set maxDate = today only
  "between date A and B"    → set both minDate and maxDate

DIFFERENCE from basic DatePicker (SECTION 5B):
  Basic:    DatePickerDialog(...).show()           ← one line, no limits
  Limited:  val dp = DatePickerDialog(...)         ← store in variable
            dp.datePicker.minDate = ...            ← set limits BEFORE show
            dp.datePicker.maxDate = ...
            dp.show()
*/

// ── In your Activity (replace the btnPickDate click listener) ──
/*
btnPickDate.setOnClickListener {
    val cal = Calendar.getInstance()

    val today = Calendar.getInstance()           // min = today

    val maxDate = Calendar.getInstance()
    maxDate.add(Calendar.DAY_OF_MONTH, 20)       // max = today + 20 days

    val datePicker = DatePickerDialog(
        this,
        { _, year, month, day ->
            selectedDate = "$day/${month + 1}/$year"
            tvDate.text = "Date: $selectedDate"
        },
        cal.get(Calendar.YEAR),
        cal.get(Calendar.MONTH),
        cal.get(Calendar.DAY_OF_MONTH)
    )

    // Set limits BEFORE calling .show()
    datePicker.datePicker.minDate = today.timeInMillis    // can't pick before today
    datePicker.datePicker.maxDate = maxDate.timeInMillis  // can't pick after 20 days

    datePicker.show()
}
*/

// ── Only future dates (no max limit) ──────────────────────────
/*
val today = Calendar.getInstance()
datePicker.datePicker.minDate = today.timeInMillis
// DO NOT set maxDate — leaves it open-ended
datePicker.show()
*/

// ── Only past dates (no min limit) ────────────────────────────
/*
val today = Calendar.getInstance()
datePicker.datePicker.maxDate = today.timeInMillis
// DO NOT set minDate — allows any past date
datePicker.show()
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 5C — LAB 5: TIME PICKER                       ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_timepicker.xml ───────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:gravity="center" android:padding="24dp">

    <Button android:id="@+id/btnPickTime"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Pick Time" android:layout_marginBottom="16dp"/>

    <TextView android:id="@+id/tvTime"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textSize="20sp" android:text="No time selected"/>
</LinearLayout>
*/

import android.app.TimePickerDialog

class Lab5C_TimePickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timepicker)

        val tvTime = findViewById<TextView>(R.id.tvTime)

        findViewById<Button>(R.id.btnPickTime).setOnClickListener {
            val cal = Calendar.getInstance()
            TimePickerDialog(
                this,
                { _, hour, minute ->
                    val amPm = if (hour < 12) "AM" else "PM"
                    val h = if (hour % 12 == 0) 12 else hour % 12
                    val m = String.format("%02d", minute)
                    tvTime.text = "Selected Time: $h:$m $amPm"
                },
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                false   // false = 12-hour, true = 24-hour
            ).show()
        }
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 5D — LAB 5: FULL BOOKING APP                  ║
// ║  (Spinner + DatePicker + TimePicker + Toggle + Submit)  ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_booking.xml ──────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent">
<LinearLayout
    android:layout_width="match_parent" android:layout_height="wrap_content"
    android:orientation="vertical" android:padding="24dp">

    <TextView android:text="Select Movie:"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:layout_marginBottom="4dp"/>
    <Spinner android:id="@+id/spinnerMovie"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:layout_marginBottom="16dp"/>

    <TextView android:text="Select Theatre:"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:layout_marginBottom="4dp"/>
    <Spinner android:id="@+id/spinnerTheatre"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:layout_marginBottom="16dp"/>

    <Button android:id="@+id/btnDate"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Select Date" android:layout_marginBottom="8dp"/>
    <TextView android:id="@+id/tvDate"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="No date" android:layout_marginBottom="16dp"/>

    <Button android:id="@+id/btnTime"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Select Time" android:layout_marginBottom="8dp"/>
    <TextView android:id="@+id/tvTime"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="No time" android:layout_marginBottom="16dp"/>

    <ToggleButton android:id="@+id/toggleTicket"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textOn="Premium" android:textOff="Standard"
        android:layout_marginBottom="16dp"/>

    <LinearLayout android:layout_width="match_parent"
        android:layout_height="wrap_content" android:orientation="horizontal">
        <Button android:id="@+id/btnBook"
            android:layout_width="0dp" android:layout_height="wrap_content"
            android:layout_weight="1" android:text="Book Now" android:layout_marginEnd="8dp"/>
        <Button android:id="@+id/btnReset"
            android:layout_width="0dp" android:layout_height="wrap_content"
            android:layout_weight="1" android:text="Reset"/>
    </LinearLayout>

</LinearLayout>
</ScrollView>
*/

class Lab5D_BookingActivity : AppCompatActivity() {
    private var selectedDate = ""
    private var selectedHour = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        // Spinners
        val movies   = arrayOf("Avengers", "Spider-Man", "Batman", "Inception")
        val theatres = arrayOf("PVR", "INOX", "Cinepolis", "Miraj")
        setupSpinner(R.id.spinnerMovie, movies)
        setupSpinner(R.id.spinnerTheatre, theatres)

        val tvDate = findViewById<TextView>(R.id.tvDate)
        val tvTime = findViewById<TextView>(R.id.tvTime)
        val toggle = findViewById<ToggleButton>(R.id.toggleTicket)
        val btnBook = findViewById<Button>(R.id.btnBook)

        // Date picker
        findViewById<Button>(R.id.btnDate).setOnClickListener {
            val cal = Calendar.getInstance()
            DatePickerDialog(this, { _, y, m, d ->
                selectedDate = "$d/${m+1}/$y"
                tvDate.text = "Date: $selectedDate"
            }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        // Time picker
        findViewById<Button>(R.id.btnTime).setOnClickListener {
            val cal = Calendar.getInstance()
            TimePickerDialog(this, { _, h, min ->
                selectedHour = h
                tvTime.text = "Time: $h:${String.format("%02d", min)}"
                // Premium only after 12 PM
                if (toggle.isChecked) btnBook.isEnabled = h >= 12
            }, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false).show()
        }

        // Premium validation
        toggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                btnBook.isEnabled = selectedHour >= 12
                if (selectedHour < 12) Toast.makeText(this, "Premium only after 12 PM", Toast.LENGTH_SHORT).show()
            } else {
                btnBook.isEnabled = true
            }
        }

        // Book now
        btnBook.setOnClickListener {
            val movie   = findViewById<Spinner>(R.id.spinnerMovie).selectedItem.toString()
            val theatre = findViewById<Spinner>(R.id.spinnerTheatre).selectedItem.toString()
            val type    = if (toggle.isChecked) "Premium" else "Standard"
            Toast.makeText(this, "Booked: $movie @ $theatre\n$selectedDate | ${tvTime.text}\nType: $type", Toast.LENGTH_LONG).show()
        }

        // Reset
        findViewById<Button>(R.id.btnReset).setOnClickListener {
            selectedDate = ""; selectedHour = 0
            tvDate.text = "No date"; tvTime.text = "No time"
            toggle.isChecked = false; btnBook.isEnabled = true
        }
    }

    private fun setupSpinner(id: Int, items: Array<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        findViewById<Spinner>(id).adapter = adapter
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 5E — CUSTOM SPINNER WITH IMAGES               ║
// ║  Use when: question asks spinner with icons/flags/pics  ║
// ╚══════════════════════════════════════════════════════════╝

/*
WHEN TO USE THIS vs normal Spinner (SECTION 5A):
  Normal Spinner  → text only items → use SECTION 5A (simpler)
  Custom Spinner  → image + text items → use THIS section

FILES NEEDED:
  1. spinner_item.xml        → layout for each row in spinner
  2. MainActivity.kt         → data class + adapter + activity

── res/layout/spinner_item.xml ───────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:padding="8dp">

    <ImageView
        android:id="@+id/imgSpinner"
        android:layout_width="40dp"
        android:layout_height="40dp"
        android:layout_marginEnd="12dp"/>

    <TextView
        android:id="@+id/tvSpinner"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="16sp"
        android:gravity="center_vertical"/>

</LinearLayout>

── activity_main.xml — just add a normal Spinner ─────────────
<Spinner
    android:id="@+id/spinner"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginBottom="16dp"/>
*/

// ── Data class to hold text + image for each item ─────────────
data class SpinnerItem(val text: String, val imageResId: Int)

// ── Custom Adapter ─────────────────────────────────────────────
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView as TV

class CustomSpinnerAdapter(
    context: Context,
    private val items: List<SpinnerItem>
) : ArrayAdapter<SpinnerItem>(context, 0, items) {

    // getView   → how item looks when spinner is CLOSED (showing selected)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return buildView(position, convertView, parent)
    }

    // getDropDownView → how item looks in the DROPDOWN list
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return buildView(position, convertView, parent)
    }

    private fun buildView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView
            ?: LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false)

        val item = items[position]
        view.findViewById<ImageView>(R.id.imgSpinner).setImageResource(item.imageResId)
        view.findViewById<TV>(R.id.tvSpinner).text = item.text
        return view
    }
}

// ── In your Activity ──────────────────────────────────────────
/*
// Step 1 — build list of SpinnerItem(text, drawable)
// NOTE: images must exist in res/drawable/ folder
val items = listOf(
    SpinnerItem("Apple",  R.drawable.ic_launcher_foreground),  // replace with real drawable
    SpinnerItem("Banana", R.drawable.ic_launcher_foreground),
    SpinnerItem("Cherry", R.drawable.ic_launcher_foreground)
)

// Step 2 — create and attach custom adapter
val adapter = CustomSpinnerAdapter(this, items)
val spinner = findViewById<Spinner>(R.id.spinner)
spinner.adapter = adapter

// Step 3 — handle selection
spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        Toast.makeText(this@MainActivity, "Selected: ${items[pos].text}", Toast.LENGTH_SHORT).show()
    }
    override fun onNothingSelected(parent: AdapterView<*>) {}
}
*/

// ── EXAM TIP ──────────────────────────────────────────────────
/*
If no custom images available in drawable → use built-in Android icons:
    R.drawable.ic_menu_camera
    R.drawable.ic_menu_call
    R.drawable.ic_menu_info_details
    R.drawable.ic_menu_mapmode
    R.drawable.ic_menu_gallery
    android.R.drawable.ic_dialog_info     ← note: android.R not just R
These are always available — no need to add files to drawable folder.
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 6 — LAB 6: OPTIONS MENU                       ║
// ╚══════════════════════════════════════════════════════════╝

/*
── res/menu/menu_main.xml ────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <item android:id="@+id/menu_workout"
        android:title="Workout Plans"
        android:icon="@drawable/ic_launcher_foreground"
        app:showAsAction="never"/>
    <item android:id="@+id/menu_trainers"
        android:title="Trainers"
        app:showAsAction="never"/>
    <item android:id="@+id/menu_membership"
        android:title="Membership"
        app:showAsAction="never"/>
    <item android:id="@+id/menu_contact"
        android:title="Contact Us"
        android:icon="@android:drawable/ic_menu_call"
        app:showAsAction="ifRoom"/>
    <item android:id="@+id/menu_about"
        android:title="About Us"
        android:icon="@android:drawable/ic_menu_info_details"
        app:showAsAction="ifRoom"/>
</menu>

── activity_menu.xml ─────────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:gravity="center">
    <TextView android:text="XYZ Fitness Center\nTap the menu ⋮"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:gravity="center" android:textSize="22sp"/>
</LinearLayout>
*/

class Lab6_MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    // Step 1: Inflate the menu
    override fun onCreateOptionsMenu(menu: android.view.Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Step 2: Handle item clicks
    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_workout    -> { Toast.makeText(this, "Workout Plans", Toast.LENGTH_SHORT).show(); true }
            R.id.menu_trainers   -> { Toast.makeText(this, "Trainers", Toast.LENGTH_SHORT).show(); true }
            R.id.menu_membership -> { Toast.makeText(this, "Membership Plans", Toast.LENGTH_SHORT).show(); true }
            R.id.menu_contact    -> { Toast.makeText(this, "Contact Us", Toast.LENGTH_SHORT).show(); true }
            R.id.menu_about      -> { Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show(); true }
            else -> super.onOptionsItemSelected(item)
        }
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 6B — OPTIONS MENU WITH NoActionBar THEME FIX  ║
// ║  Use when: menu dots (⋮) not showing on screen         ║
// ║  Cause:    Theme.Material3 or NoActionBar theme         ║
// ╚══════════════════════════════════════════════════════════╝

/*
WHY THIS HAPPENS:
  Default new projects use Theme.Material3.DayNight.NoActionBar
  "NoActionBar" = no toolbar = menu has nowhere to appear
  Fix = add a Toolbar manually + tell the Activity to use it

STEP 1 — Add Toolbar to your activity XML (FIRST item inside LinearLayout):
──────────────────────────────────────────────────────────────
<androidx.appcompat.widget.Toolbar
    android:id="@+id/toolbar"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"
    android:background="?attr/colorPrimary"
    android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"/>
──────────────────────────────────────────────────────────────

STEP 2 — Add this ONE LINE in MainActivity.kt inside onCreate,
         right after setContentView():
──────────────────────────────────────────────────────────────
setSupportActionBar(findViewById(R.id.toolbar))
──────────────────────────────────────────────────────────────

STEP 3 — onCreateOptionsMenu and onOptionsItemSelected stay EXACTLY
         the same as SECTION 6. No other changes needed.

QUICK CHECK — open res/values/themes.xml:
  If you see "NoActionBar" in the theme name → you need this fix
  If you see "DarkActionBar"                 → Section 6 works as-is
*/

// ── Full MainActivity example with Toolbar fix ────────────────
/*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ADD THIS LINE — without it, menu won't show with NoActionBar theme
        setSupportActionBar(findViewById(R.id.toolbar))

        // ... rest of your code ...
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)   // same as Section 6
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_refresh -> { /* your action */ true }
            R.id.menu_about   -> { /* your action */ true }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 7A — LAB 7: CONTEXT MENU (Long Press)         ║
// ╚══════════════════════════════════════════════════════════╝

/*
── res/menu/context_menu.xml ─────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:id="@+id/ctx_open"      android:title="Open"/>
    <item android:id="@+id/ctx_uninstall" android:title="Uninstall"/>
    <item android:id="@+id/ctx_details"   android:title="View Details"/>
</menu>

── activity_context_menu.xml ─────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical">
    <ListView android:id="@+id/listViewApps"
        android:layout_width="match_parent" android:layout_height="match_parent"/>
</LinearLayout>
*/

import android.view.ContextMenu
import android.view.MenuItem
import android.view.View

class Lab7A_ContextMenuActivity : AppCompatActivity() {
    private val items = arrayOf("Settings", "Calculator", "Camera", "Gallery", "Maps")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context_menu)

        val listView = findViewById<ListView>(R.id.listViewApps)
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

        // Register list for context menu (long press)
        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
        menu.setHeaderTitle("Choose Action")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.ctx_open      -> { Toast.makeText(this, "Opening app...", Toast.LENGTH_SHORT).show(); true }
            R.id.ctx_uninstall -> { Toast.makeText(this, "Uninstall selected", Toast.LENGTH_SHORT).show(); true }
            R.id.ctx_details   -> { Toast.makeText(this, "Viewing details...", Toast.LENGTH_SHORT).show(); true }
            else -> super.onContextItemSelected(item)
        }
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 7B — LAB 7: POPUP MENU                        ║
// ╚══════════════════════════════════════════════════════════╝

/*
── res/menu/popup_menu.xml ───────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:id="@+id/popup_search"    android:title="Search Keywords"/>
    <item android:id="@+id/popup_highlight" android:title="Highlight"/>
    <item android:id="@+id/popup_sort"      android:title="Sort Content"/>
</menu>

── activity_popup.xml ────────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="16dp">

    <Button android:id="@+id/btnShowPopup"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Filter Options" android:layout_marginBottom="16dp"/>

    <TextView android:id="@+id/tvContent"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Digital Transformation is the integration of digital technology into all areas of a business..."
        android:textSize="16sp"/>
</LinearLayout>
*/

import android.widget.PopupMenu

class Lab7B_PopupMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)

        findViewById<Button>(R.id.btnShowPopup).setOnClickListener { view ->
            // Step 1: Create PopupMenu anchored to the button
            val popupMenu = PopupMenu(this, view)
            // Step 2: Inflate menu resource
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
            // Step 3: Handle item clicks
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.popup_search    -> { Toast.makeText(this, "Search Keywords", Toast.LENGTH_SHORT).show(); true }
                    R.id.popup_highlight -> { Toast.makeText(this, "Highlight selected", Toast.LENGTH_SHORT).show(); true }
                    R.id.popup_sort      -> { Toast.makeText(this, "Sort Content", Toast.LENGTH_SHORT).show(); true }
                    else -> false
                }
            }
            // Step 4: Show it
            popupMenu.show()
        }
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 8A — LAB 8: SQLITE DATABASE                   ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_sqlite.xml ───────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="16dp">

    <EditText android:id="@+id/etName"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Task Name" android:layout_marginBottom="8dp"/>
    <EditText android:id="@+id/etDate"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Due Date" android:layout_marginBottom="8dp"/>
    <Spinner android:id="@+id/spinnerPriority"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:layout_marginBottom="16dp"/>
    <Button android:id="@+id/btnSave"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Save Task" android:layout_marginBottom="16dp"/>
    <ListView android:id="@+id/lvTasks"
        android:layout_width="match_parent" android:layout_height="match_parent"/>
</LinearLayout>
*/

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// ── Database Helper ────────────────────────────────────────────
class DBHelper(context: Context) : SQLiteOpenHelper(context, "TaskDB.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE tasks (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT, " +
            "due_date TEXT, " +
            "priority TEXT)"
        )
    }
    override fun onUpgrade(db: SQLiteDatabase, old: Int, new: Int) {
        db.execSQL("DROP TABLE IF EXISTS tasks")
        onCreate(db)
    }

    // INSERT
    fun insertTask(name: String, date: String, priority: String): Long {
        val db = writableDatabase
        val cv = ContentValues().apply {
            put("name", name)
            put("due_date", date)
            put("priority", priority)
        }
        return db.insert("tasks", null, cv)
    }

    // READ ALL
    fun getAllTasks(): List<String> {
        val tasks = mutableListOf<String>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM tasks", null)
        while (cursor.moveToNext()) {
            val name     = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val date     = cursor.getString(cursor.getColumnIndexOrThrow("due_date"))
            val priority = cursor.getString(cursor.getColumnIndexOrThrow("priority"))
            tasks.add("$name | $date | $priority")
        }
        cursor.close()
        return tasks
    }

    // DELETE
    fun deleteTask(id: Int) {
        writableDatabase.delete("tasks", "id=?", arrayOf(id.toString()))
    }

    // UPDATE
    fun updateTask(id: Int, name: String, date: String, priority: String) {
        val cv = ContentValues().apply {
            put("name", name)
            put("due_date", date)
            put("priority", priority)
        }
        writableDatabase.update("tasks", cv, "id=?", arrayOf(id.toString()))
    }
}

// ── Activity ───────────────────────────────────────────────────
class Lab8A_SQLiteActivity : AppCompatActivity() {
    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        dbHelper = DBHelper(this)

        val priorities = arrayOf("High", "Medium", "Low")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, priorities)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        val spinner = findViewById<Spinner>(R.id.spinnerPriority)
        spinner.adapter = spinnerAdapter

        val etName = findViewById<EditText>(R.id.etName)
        val etDate = findViewById<EditText>(R.id.etDate)

        // Save Task
        findViewById<Button>(R.id.btnSave).setOnClickListener {
            val name     = etName.text.toString().trim()
            val date     = etDate.text.toString().trim()
            val priority = spinner.selectedItem.toString()
            if (name.isEmpty()) { Toast.makeText(this, "Enter task name", Toast.LENGTH_SHORT).show(); return@setOnClickListener }
            dbHelper.insertTask(name, date, priority)
            Toast.makeText(this, "Task saved!", Toast.LENGTH_SHORT).show()
            etName.text.clear(); etDate.text.clear()
            loadTasks()
        }
        loadTasks()
    }

    private fun loadTasks() {
        val tasks = dbHelper.getAllTasks()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks)
        findViewById<ListView>(R.id.lvTasks).adapter = adapter
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 8B — LAB 8: SHARED PREFERENCES                ║
// ╚══════════════════════════════════════════════════════════╝

/*
── activity_prefs.xml ────────────────────────────────────────
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:gravity="center" android:padding="24dp">

    <EditText android:id="@+id/etUsername"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Enter Username" android:layout_marginBottom="12dp"/>
    <EditText android:id="@+id/etEmail"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Enter Email" android:layout_marginBottom="20dp"/>
    <Button android:id="@+id/btnSavePrefs"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Save"/>
</LinearLayout>
*/

class Lab8B_SharedPrefsActivity : AppCompatActivity() {
    private val PREF_NAME = "MyAppPrefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prefs)

        val prefs    = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val etName   = findViewById<EditText>(R.id.etUsername)
        val etEmail  = findViewById<EditText>(R.id.etEmail)

        // RESTORE saved values on open
        etName.setText(prefs.getString("username", ""))
        etEmail.setText(prefs.getString("email", ""))

        // SAVE on button click
        findViewById<Button>(R.id.btnSavePrefs).setOnClickListener {
            prefs.edit().apply {
                putString("username", etName.text.toString())
                putString("email",    etEmail.text.toString())
                apply() // async save
            }
            Toast.makeText(this, "Saved! Will restore on next open.", Toast.LENGTH_SHORT).show()
        }
    }
}


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION EXTRAS — USEFUL SNIPPETS                       ║
// ╚══════════════════════════════════════════════════════════╝

// ── Navigate to another Activity ──────────────────────────────
/*
val intent = Intent(this, TargetActivity::class.java)
intent.putExtra("KEY", "value")   // pass data
startActivity(intent)
*/

// ── Get data in the receiving Activity ────────────────────────
/*
val data = intent.getStringExtra("KEY")   // String
val num  = intent.getIntExtra("NUM", 0)  // Int (0 is default)
*/

// ── Back button (finish current activity) ─────────────────────
/*
btnBack.setOnClickListener { finish() }
*/

// ── EditText validation ────────────────────────────────────────
/*
val text = editText.text.toString().trim()
if (text.isEmpty()) {
    editText.error = "Field cannot be empty"
    return
}
*/

// ── RadioButton check ─────────────────────────────────────────
/*
val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
val selectedId = radioGroup.checkedRadioButtonId
val radioBtn   = findViewById<RadioButton>(selectedId)
val text       = radioBtn.text.toString()
*/

// ── SeekBar ───────────────────────────────────────────────────
/*
seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
    override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
        tvValue.text = "Value: $progress"
    }
    override fun onStartTrackingTouch(sb: SeekBar?) {}
    override fun onStopTrackingTouch(sb: SeekBar?) {}
})
*/

// ── TableLayout row in XML ────────────────────────────────────
/*
<TableRow>
    <TextView android:text="Column 1" android:padding="8dp"/>
    <TextView android:text="Column 2" android:padding="8dp"/>
    <TextView android:text="Column 3" android:padding="8dp"/>
</TableRow>
*/

// ── Custom Toast ──────────────────────────────────────────────
/*
val inflater = layoutInflater
val layout   = inflater.inflate(R.layout.custom_toast, null)
val toast    = Toast(applicationContext)
toast.duration = Toast.LENGTH_LONG
toast.view   = layout
toast.show()
*/

// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 9 — COMMON EXAM TRAPS & QUICK FIXES           ║
// ╚══════════════════════════════════════════════════════════╝

// ── TRAP 1: Menu not showing ───────────────────────────────────
/*
SYMPTOM: App runs, three dots don't appear
FIX:     Check themes.xml — if NoActionBar → use SECTION 6B (Toolbar fix)
         setSupportActionBar(findViewById(R.id.toolbar))
*/

// ── TRAP 2: Unresolved reference 'R' ──────────────────────────
/*
SYMPTOM: Red error on R.id.xxx or R.layout.xxx
FIX:     Your package name is wrong on line 1 of .kt file
         Check AndroidManifest.xml first line for correct package name
         Change: package com.example.hospitalapp
         To:     package com.example.myapplication  (whatever yours is)
*/

// ── TRAP 3: Duplicate <?xml declaration ───────────────────────
/*
SYMPTOM: "processing instruction target matching [xX][mM][lL] not allowed"
FIX:     Android Studio auto-adds <?xml line when you create a new file
         Delete the SECOND <?xml line — keep only ONE at the very top
*/

// ── TRAP 4: Menu file name mismatch ───────────────────────────
/*
SYMPTOM: Unresolved reference 'menu_main'
FIX:     File name in res/menu/ must match what you write in Kotlin
         File = main_menu.xml  →  menuInflater.inflate(R.menu.main_menu, menu)
         File = menu_main.xml  →  menuInflater.inflate(R.menu.menu_main, menu)
*/

// ── TRAP 5: Wrong project template ────────────────────────────
/*
SYMPTOM: No activity_main.xml, sees setContent{} in MainActivity
FIX:     You chose "Empty Activity" (Compose) instead of "Empty Views Activity"
         Delete project → New Project → "Empty Views Activity" ← correct one
*/

// ── TRAP 6: ConfirmationActivity crash on launch ──────────────
/*
SYMPTOM: App crashes when going to second screen
FIX:     You forgot to register the activity in AndroidManifest.xml
         Add inside <application> block:
         <activity android:name=".ConfirmationActivity" android:exported="false"/>
*/

// ── TRAP 7: Spinner shows nothing / crashes ────────────────────
/*
SYMPTOM: Spinner is blank or app crashes on spinner
FIX:     Make sure you call BOTH lines:
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
         spinner.adapter = adapter
         Without setDropDownViewResource, dropdown won't open properly
*/

// ── TRAP 8: DatePicker month is off by 1 ──────────────────────
/*
SYMPTOM: User picks March but app shows February
FIX:     DatePickerDialog returns month 0-indexed (Jan=0, Dec=11)
         Always use (month + 1) when displaying:
         val date = "$day/${month + 1}/$year"   ← correct
         val date = "$day/$month/$year"          ← wrong, always 1 behind
*/

// ── TRAP 9: Back button closes entire app instead of going back ─
/*
SYMPTOM: Pressing Back button on confirmation page closes the app
FIX:     Use finish() not startActivity() to go back
         btnBack.setOnClickListener { finish() }   ← correct
         DO NOT do: startActivity(Intent(this, MainActivity::class.java))
         That creates a NEW MainActivity instead of returning to the old one
*/

// ── TRAP 10: EditText .error not showing ──────────────────────
/*
SYMPTOM: etName.error = "..." but red error doesn't appear
FIX:     Make sure you called return@setOnClickListener AFTER setting error
         etName.error = "Please enter name"
         return@setOnClickListener          ← without this, code keeps running
*/


// ─────────────────────────────────────────────────────────────
// END OF CHEAT SHEET
// ─────────────────────────────────────────────────────────────
