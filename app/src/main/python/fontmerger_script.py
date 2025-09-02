import sys

# Your existing imports here

def main_ui(input_path, output_path='merged_font.ttf'):
    # Your existing code
    # Modify the saving logic to use output_path instead of hardcoded name
    with open(output_path, 'wb') as f:
        f.write(merged_font_data)

if __name__ == '__main__':
    input_path = sys.argv[1]
    output_path = sys.argv[2] if len(sys.argv) > 2 else 'merged_font.ttf'
    main_ui(input_path, output_path)