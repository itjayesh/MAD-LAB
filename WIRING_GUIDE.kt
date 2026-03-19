// ============================================================
//  MAD LAB — WIRING GUIDE (findViewById Reference)
//  HOW TO USE:
//  1. Look up the XML element you used
//  2. Copy the matching findViewById line
//  3. Paste inside onCreate() after setContentView()
//  4. Use the variable anywhere in the activity
// ============================================================


// ╔══════════════════════════════════════════════════════════╗
// ║  WHAT IS WIRING?                                        ║
// ╚══════════════════════════════════════════════════════════╝
/*
XML gives a view an ID:
    <EditText android:id="@+id/etName" ... />

Kotlin "wires" it by finding that ID:
    val etName = findViewById<EditText>(R.id.etName)

After wiring, you can use the variable:
    etName.text.toString()   → read value
    etName.error = "..."     → show red error
    etName.text.clear()      → clear the field

GOLDEN RULE: The ID in XML must EXACTLY match the ID in Kotlin
    XML:    android:id="@+id/etName"
    Kotlin: findViewById<EditText>(R.id.etName)
                                        ^^^^^^ same name
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 1 — EDITTEXT                                   ║
// ╚══════════════════════════════════════════════════════════╝
/*
── XML ───────────────────────────────────────────────────────
<EditText
    android:id="@+id/etName"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="Enter name"
    android:inputType="textPersonName"/>

── Kotlin (inside onCreate) ──────────────────────────────────
val etName = findViewById<EditText>(R.id.etName)

── Common operations ─────────────────────────────────────────
val text    = etName.text.toString().trim()   // read value
val isEmpty = text.isEmpty()                  // check empty
etName.error = "Field required"               // show error
etName.text.clear()                           // clear field
etName.setText("Hello")                       // set value

── inputType quick reference ─────────────────────────────────
textPersonName    → name field
phone             → phone number (numeric keypad)
textEmailAddress  → email field
number            → whole numbers only
numberDecimal     → decimal numbers
textPassword      → hidden password
textMultiLine     → multi line text box
textUri           → URL field
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 2 — BUTTON                                     ║
// ╚══════════════════════════════════════════════════════════╝
/*
── XML ───────────────────────────────────────────────────────
<Button
    android:id="@+id/btnSubmit"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="SUBMIT"/>

── Kotlin ────────────────────────────────────────────────────
val btnSubmit = findViewById<Button>(R.id.btnSubmit)

── Common operations ─────────────────────────────────────────
btnSubmit.setOnClickListener {
    // your code here
}
btnSubmit.isEnabled = false    // disable button
btnSubmit.isEnabled = true     // enable button
btnSubmit.text = "DONE"        // change label
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 3 — TEXTVIEW                                   ║
// ╚══════════════════════════════════════════════════════════╝
/*
── XML ───────────────────────────────────────────────────────
<TextView
    android:id="@+id/tvResult"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Result appears here"/>

── Kotlin ────────────────────────────────────────────────────
val tvResult = findViewById<TextView>(R.id.tvResult)

── Common operations ─────────────────────────────────────────
tvResult.text = "Hello World"          // set text
tvResult.text = "Name: $name"          // set with variable
val current = tvResult.text.toString() // read current text
tvResult.append("\nNew line")          // add to existing text
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 4 — SPINNER                                    ║
// ╚══════════════════════════════════════════════════════════╝
/*
── XML ───────────────────────────────────────────────────────
<Spinner
    android:id="@+id/spinnerDept"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>

── Kotlin ────────────────────────────────────────────────────
val spinner = findViewById<Spinner>(R.id.spinnerDept)

// Wiring the DATA (always needed after wiring the view):
val items = arrayOf("Select", "Option A", "Option B")
val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
spinner.adapter = adapter

── Common operations ─────────────────────────────────────────
val selected = spinner.selectedItem.toString()  // get selected value
spinner.setSelection(0)                         // reset to first item
spinner.selectedItemPosition                    // get index (0, 1, 2...)
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 5 — TOGGLEBUTTON                               ║
// ╚══════════════════════════════════════════════════════════╝
/*
── XML ───────────────────────────────────────────────────────
<ToggleButton
    android:id="@+id/toggleBtn"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:textOn="Online"
    android:textOff="In-Person"/>

── Kotlin ────────────────────────────────────────────────────
val toggleBtn = findViewById<ToggleButton>(R.id.toggleBtn)

── Common operations ─────────────────────────────────────────
val isOn     = toggleBtn.isChecked              // true if ON
val label    = toggleBtn.text.toString()        // "Online" or "In-Person"
val value    = if (toggleBtn.isChecked) "Online" else "In-Person"
toggleBtn.isChecked = false                     // reset to OFF state

// Detect change:
toggleBtn.setOnCheckedChangeListener { _, isChecked ->
    if (isChecked) { /* ON */ } else { /* OFF */ }
}
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 6 — CHECKBOX                                   ║
// ╚══════════════════════════════════════════════════════════╝
/*
── XML ───────────────────────────────────────────────────────
<CheckBox
    android:id="@+id/cbBurger"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Burger - ₹120"/>

── Kotlin ────────────────────────────────────────────────────
val cbBurger = findViewById<CheckBox>(R.id.cbBurger)

── Common operations ─────────────────────────────────────────
val isChecked  = cbBurger.isChecked          // true if ticked
cbBurger.isChecked = false                   // untick it
cbBurger.isEnabled = false                   // lock it (can't change)

// Check on button click:
if (cbBurger.isChecked) {
    // add to order
}
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 7 — RADIOGROUP + RADIOBUTTON                   ║
// ╚══════════════════════════════════════════════════════════╝
/*
── XML ───────────────────────────────────────────────────────
<RadioGroup
    android:id="@+id/radioGroup"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content">

    <RadioButton android:id="@+id/rbBasic"    android:text="Basic"/>
    <RadioButton android:id="@+id/rbStandard" android:text="Standard"/>
    <RadioButton android:id="@+id/rbPremium"  android:text="Premium"/>
</RadioGroup>

── Kotlin ────────────────────────────────────────────────────
val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

── Common operations ─────────────────────────────────────────
val selectedId  = radioGroup.checkedRadioButtonId   // get selected ID
                                                    // returns -1 if none selected
val selectedBtn = findViewById<RadioButton>(selectedId)
val selectedText = selectedBtn.text.toString()      // get label text

radioGroup.clearCheck()                             // deselect all (reset)
radioGroup.check(R.id.rbBasic)                      // programmatically select one

// Validate:
if (selectedId == -1) {
    Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show()
    return@setOnClickListener
}
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 8 — SEEKBAR                                    ║
// ╚══════════════════════════════════════════════════════════╝
/*
── XML ───────────────────────────────────────────────────────
<SeekBar
    android:id="@+id/seekBar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:max="10"
    android:progress="5"/>

── Kotlin ────────────────────────────────────────────────────
val seekBar = findViewById<SeekBar>(R.id.seekBar)

── Common operations ─────────────────────────────────────────
val value   = seekBar.progress      // get current value
val maxVal  = seekBar.max           // get max value
seekBar.progress = 0                // reset to 0

// Listen for changes:
seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
    override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
        tvValue.text = "Value: $progress"    // update live
    }
    override fun onStartTrackingTouch(sb: SeekBar?) {}   // leave empty
    override fun onStopTrackingTouch(sb: SeekBar?) {     // when user lets go
        Toast.makeText(this@MainActivity, "Final: ${sb?.progress}", Toast.LENGTH_SHORT).show()
    }
})
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 9 — TOOLBAR                                    ║
// ╚══════════════════════════════════════════════════════════╝
/*
── XML (FIRST item inside LinearLayout) ──────────────────────
<androidx.appcompat.widget.Toolbar
    android:id="@+id/toolbar"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"
    android:background="?attr/colorPrimary"
    android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"/>

── Kotlin (FIRST line after setContentView) ──────────────────
setSupportActionBar(findViewById(R.id.toolbar))

── WHY needed ────────────────────────────────────────────────
Default new projects use NoActionBar theme
→ menu dots won't show without this
→ always add when theme contains "NoActionBar"
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 10 — DATEPICKER BUTTON + TEXTVIEW              ║
// ╚══════════════════════════════════════════════════════════╝
/*
── XML ───────────────────────────────────────────────────────
<Button  android:id="@+id/btnPickDate" android:text="Pick Date".../>
<TextView android:id="@+id/tvDate"    android:text="No date selected".../>

── Kotlin ────────────────────────────────────────────────────
val btnPickDate = findViewById<Button>(R.id.btnPickDate)
val tvDate      = findViewById<TextView>(R.id.tvDate)
var selectedDate = ""    // store date as a variable at top of class

btnPickDate.setOnClickListener {
    val cal = Calendar.getInstance()
    DatePickerDialog(this, { _, year, month, day ->
        selectedDate = "$day/${month + 1}/$year"   // month+1 always!
        tvDate.text = "Date: $selectedDate"
    }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
       cal.get(Calendar.DAY_OF_MONTH)).show()
}

// Validate date was picked:
if (selectedDate.isEmpty()) {
    Toast.makeText(this, "Please select a date", Toast.LENGTH_SHORT).show()
    return@setOnClickListener
}
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 11 — TIMEPICKER BUTTON + TEXTVIEW             ║
// ╚══════════════════════════════════════════════════════════╝
/*
── XML ───────────────────────────────────────────────────────
<Button  android:id="@+id/btnPickTime" android:text="Pick Time".../>
<TextView android:id="@+id/tvTime"    android:text="No time selected".../>

── Kotlin ────────────────────────────────────────────────────
val btnPickTime = findViewById<Button>(R.id.btnPickTime)
val tvTime      = findViewById<TextView>(R.id.tvTime)
var selectedTime = ""

btnPickTime.setOnClickListener {
    val cal = Calendar.getInstance()
    TimePickerDialog(this, { _, hour, minute ->
        val amPm = if (hour < 12) "AM" else "PM"
        val h = if (hour % 12 == 0) 12 else hour % 12
        val m = String.format("%02d", minute)
        selectedTime = "$h:$m $amPm"
        tvTime.text = "Time: $selectedTime"
    }, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false).show()
}
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 12 — INTENT (passing data to next page)        ║
// ╚══════════════════════════════════════════════════════════╝
/*
── Sending data (in MainActivity) ────────────────────────────
val intent = Intent(this, ConfirmationActivity::class.java)
intent.putExtra("NAME",  name)       // String
intent.putExtra("PHONE", phone)      // String
intent.putExtra("COUNT", 5)          // Int
startActivity(intent)

── Receiving data (in ConfirmationActivity) ──────────────────
val name  = intent.getStringExtra("NAME")  ?: ""
val phone = intent.getStringExtra("PHONE") ?: ""
val count = intent.getIntExtra("COUNT", 0)     // 0 is default

── Display received data ─────────────────────────────────────
findViewById<TextView>(R.id.tvName).text  = "Name: $name"
findViewById<TextView>(R.id.tvPhone).text = "Phone: $phone"

── Back button ───────────────────────────────────────────────
findViewById<Button>(R.id.btnBack).setOnClickListener {
    finish()    // closes current activity, goes back to previous
}

── Menu item opening new page ────────────────────────────────
R.id.menu_help -> {
    startActivity(Intent(this, HelpActivity::class.java))
    true
}
*/


// ╔══════════════════════════════════════════════════════════╗
// ║  SECTION 13 — COMPLETE WIRING TEMPLATE                  ║
// ║  Copy this as your starting point for any activity      ║
// ╚══════════════════════════════════════════════════════════╝
/*
class MainActivity : AppCompatActivity() {

    private var selectedDate = ""   // date stored here (not inside onCreate)
    private var selectedTime = ""   // time stored here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ── STEP 1: Toolbar (only if NoActionBar theme) ──────
        setSupportActionBar(findViewById(R.id.toolbar))

        // ── STEP 2: Wire up all views ─────────────────────────
        val etName    = findViewById<EditText>(R.id.etName)
        val etPhone   = findViewById<EditText>(R.id.etPhone)
        val spinner   = findViewById<Spinner>(R.id.spinnerDept)
        val btnDate   = findViewById<Button>(R.id.btnPickDate)
        val tvDate    = findViewById<TextView>(R.id.tvDate)
        val toggleBtn = findViewById<ToggleButton>(R.id.toggleBtn)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        // ── STEP 3: Setup Spinner data ────────────────────────
        val items = arrayOf("Select", "Option A", "Option B")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // ── STEP 4: Date Picker ───────────────────────────────
        btnDate.setOnClickListener {
            val cal = Calendar.getInstance()
            DatePickerDialog(this, { _, y, m, d ->
                selectedDate = "$d/${m+1}/$y"
                tvDate.text = "Date: $selectedDate"
            }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
               cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        // ── STEP 5: Submit button ─────────────────────────────
        btnSubmit.setOnClickListener {
            val name  = etName.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val dept  = spinner.selectedItem.toString()
            val type  = if (toggleBtn.isChecked) "Online" else "Offline"

            // Validate
            if (name.isEmpty())  { etName.error  = "Required"; return@setOnClickListener }
            if (phone.isEmpty()) { etPhone.error = "Required"; return@setOnClickListener }
            if (dept == "Select") { Toast.makeText(this, "Select an option", Toast.LENGTH_SHORT).show(); return@setOnClickListener }
            if (selectedDate.isEmpty()) { Toast.makeText(this, "Select a date", Toast.LENGTH_SHORT).show(); return@setOnClickListener }

            // Go to next page
            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("NAME",  name)
            intent.putExtra("PHONE", phone)
            intent.putExtra("DEPT",  dept)
            intent.putExtra("DATE",  selectedDate)
            intent.putExtra("TYPE",  type)
            startActivity(intent)
        }
    }

    // ── STEP 6: Menu ──────────────────────────────────────────
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_refresh -> { resetForm(); true }
            R.id.menu_help    -> { startActivity(Intent(this, HelpActivity::class.java)); true }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // ── STEP 7: Reset form ────────────────────────────────────
    private fun resetForm() {
        findViewById<EditText>(R.id.etName).text.clear()
        findViewById<EditText>(R.id.etPhone).text.clear()
        findViewById<Spinner>(R.id.spinnerDept).setSelection(0)
        selectedDate = ""
        findViewById<TextView>(R.id.tvDate).text = "No date selected"
        findViewById<ToggleButton>(R.id.toggleBtn).isChecked = false
    }
}
*/

// ─────────────────────────────────────────────────────────────
// END OF WIRING GUIDE
// ─────────────────────────────────────────────────────────────
