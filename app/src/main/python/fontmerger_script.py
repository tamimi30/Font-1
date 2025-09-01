import fonttools
from fontTools.ttLib import TTFont
from rich import print

def main_ui(font1_path, font2_path):
    try:
        font1 = TTFont(font1_path)
        font2 = TTFont(font2_path)
        # مثال: دمج الـ glyphs من الخط الثاني للخط الأول
        for table in font2.keys():
            if table not in font1.keys():
                font1[table] = font2[table]
        out_path = "merged_font.ttf"
        font1.save(out_path)
        return f"تم الدمج! تم حفظ الخط في: {out_path}"
    except Exception as e:
        return f"حدث خطأ أثناء الدمج: {str(e)}"