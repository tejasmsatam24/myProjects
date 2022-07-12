print("Temperature in Fahrenheit: ")

tF = input()

def Fahrenheit_to_Kelvin(F):
    return 273.5 + ((float(F) - 32.0) * (5.0/9.0))

print("Temperature in Kelvin ( K ) = {:.3f}"
.format(Fahrenheit_to_Kelvin( tF )))