from PIL import Image
from pytesseract import pytesseract
path_to_tesseract = r"C:\Users\tejas\Documents\GitHub\myProjects\Python\Tesseract-OCR\tesseract.exe"
image_path = r"C:\Users\tejas\Documents\GitHub\myProjects\Python\extreme_text.jpg"

img = Image.open(image_path)

pytesseract.tesseract_cmd = path_to_tesseract

text = pytesseract.image_to_string(img)

print(text[:-1])
