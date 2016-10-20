# Weather App automated test case
#Todo Have to do calabash setup to run and validate this
Given /^I am on the Weather Screen$/ do
    check_element_exists("textField placeholder:'Pressure'")
end

Given /^I am on the Weather Screen$/ do
    check_element_exists("textField placeholder:'Humidity'")
end

Given /^I am on the Weather Screen$/ do
    check_element_exists("textField placeholder:'Wind'")
end

Then /^I enter "([^\"]*)" as "([^\"]*)"$/ do |text, content_description|
  enter_text("android.widget.EditText {contentDescription LIKE[c] '#{content_description}'}", text)
end

Given /^I press the "([^\"]*)" button$/ do |text|
  tap_when_element_exists("android.widget.Button {text CONTAINS[c] '#{text}'}")
end
