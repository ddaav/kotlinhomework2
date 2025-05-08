package com.example.kotlinhomework


import android.R.attr.onClick
import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { padding ->
                MainActivity(padding)


            }

        }
    }
}



@Composable
fun MainActivity (paddingValues: PaddingValues){
    // var counter: Int = 0

    var name by remember { mutableStateOf("") }
    var name1 by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var selectCountry by remember { mutableStateOf("Select country") }
    var dob by remember { mutableStateOf("") }
    val calendar = Calendar.getInstance()
    val context = LocalContext.current
    // Open date picker on click
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            dob = "$dayOfMonth/${month + 1}/$year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    var expanded by remember { mutableStateOf(false) }
    var selectedCountry by remember { mutableStateOf("Select Country") }

    val countries = listOf("Nepal", "India", "USA", "UK", "Australia")

    var selectedGender by remember { mutableStateOf("Male") }
    var isChecked by remember { mutableStateOf(false) }






    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Spacer(modifier = Modifier.height(30.dp))
        Box (modifier = Modifier
            .fillMaxSize(0.95f)
            .border(4.dp, color = Color.Black)
            .padding(30.dp)

        ) {
            Column (modifier = Modifier.padding(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Row {
                    Text(text = "Register")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row (modifier = Modifier.padding(10.dp)

                ){

                    OutlinedTextField(
                        value = name,
                        onValueChange = {

                            name = it
                        },
                        modifier = Modifier
                            .width(160.dp)
                            .padding(horizontal = 5.dp),
                        placeholder = {
                            Text(text = "First Name")
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                            focusedIndicatorColor = Color.Green,
                            unfocusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                            unfocusedIndicatorColor = Color.Black
                        ),
                        shape = RoundedCornerShape(12.dp),

                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        )

                    )

                    OutlinedTextField(
                        value = name1,
                        onValueChange = {

                            name1 = it
                        },
                        modifier = Modifier
                            .width(160.dp)


                            .padding(horizontal = 8.dp),
                        placeholder = {
                            Text(text = "last Name")
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                            focusedIndicatorColor = Color.Green,
                            unfocusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                            unfocusedIndicatorColor = Color.Black
                        ),
                        shape = RoundedCornerShape(12.dp),

                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        )

                    )
                }

                OutlinedTextField(
                    value = email,
                    onValueChange = {

                        email = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp),
                    placeholder = {
                        Text(text = "Email")
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                        focusedIndicatorColor = Color.Green,
                        unfocusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                        unfocusedIndicatorColor = Color.Black
                    ),
                    shape = RoundedCornerShape(12.dp),

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )

                )

                Spacer(modifier = Modifier.padding(5.dp))

                OutlinedTextField(
                    value = selectCountry,
                    onValueChange = {
                    }, readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp)
                        .clickable{

                        }
                    ,
                    placeholder = {
                        Text(text = "Select Country")

                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = "Dropdown",
                            modifier = Modifier.clickable {
                            }
                        )}
                    ,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                        focusedIndicatorColor = Color.Green,
                        unfocusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                        unfocusedIndicatorColor = Color.Black
                    ),
                    shape = RoundedCornerShape(12.dp),

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    countries.forEach { country ->
                        DropdownMenuItem(
                            onClick = {
                                selectedCountry = country
                                expanded = false
                            },
                            text = TODO(country)

                        )
                    }
                }

                Spacer(modifier = Modifier.padding(5.dp))

                OutlinedTextField(
                    value = dob,
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable{
                            datePickerDialog.show()
                        }
                        .padding(horizontal = 5.dp),

                    placeholder = {
                        Text(text = "DOB(date of birth)")
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.DateRange,
                            contentDescription = "Select Date",
                            modifier = Modifier.clickable {
                                datePickerDialog.show()
                            }
                        )
                    },
                    readOnly = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                        focusedIndicatorColor = Color.Green,
                        unfocusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                        unfocusedIndicatorColor = Color.Black
                    ),
                    shape = RoundedCornerShape(12.dp),

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )

                )

                Spacer(modifier = Modifier.padding(top = 10.dp))

                Text(text = " Select Gender" )
                Row(modifier = Modifier.padding(top = 8.dp)) {


                    GenderOption("Male", selectedGender) { selectedGender = it }
                    Spacer(modifier = Modifier.width(16.dp))
                    GenderOption("Female", selectedGender) { selectedGender = it }
                    Spacer(modifier = Modifier.width(16.dp))
                    GenderOption("Others", selectedGender) { selectedGender = it }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it }
                    )
                    Text(
                        text = "I accept terms and conditions",
                        modifier = Modifier.padding(start = 8.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }

                Button(
                    onClick = {  },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(50.dp)
                ) {
                    Text(text = "Register", fontSize = 18.sp)
                }

                Text(
                    text = "Already have an account? Sign in",
                    color = Color.Blue,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .clickable {}
                )








            }


        }


    }
}




@Composable
fun GenderOption(label: String, selected: String, onSelect: (String) -> Unit) {
    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
        RadioButton(
            selected = selected == label,
            onClick = { onSelect(label) }
        )
        Text(label, modifier = Modifier.padding(start = 4.dp))
    }
}
@Preview
@Composable
fun PreviewMain(){
    MainActivity(paddingValues = PaddingValues(0.dp))
}