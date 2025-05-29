section .data
    linefeed db 0x0a, 0                ; newline character
    digit_buffer db '0000000000', 0    ; buffer for number conversion
    count_message db "stack count: ", 0

section .bss
    stack resd 3                       ; space for 3 integers
    stack_top resd 1                   ; pointer to stack top

section .text
global _start

_start:
    ;------------------------------------------
    ; void main()
    ; Entry point of the program
    ; Initialises the stack, pushes values, and prints the stack count
    ;------------------------------------------
    lea eax, [stack]                   ; initialise stack
    mov [stack_top], eax
    mov eax, 1                         ; push 1
    call push
    mov eax, 2                         ; push 2
    call push
    mov eax, 3                         ; push 3
    call push

    mov eax, 4                         ; print count message
    mov ebx, 1
    lea ecx, [count_message]
    mov edx, 13
    int 0x80

    call count_stack_items             ; count items
    call print_int                     ; print count
    call print_newline                 ; print newline

    mov eax, 1                         ; exit
    xor ebx, ebx
    int 0x80

push:
    ;------------------------------------------
    ; void push(int value)
    ; Pushes a value onto the stack
    ;------------------------------------------
    mov ebx, [stack_top]               ; get stack top
    mov [ebx], eax                     ; store value
    add ebx, 4                         ; move top up
    mov [stack_top], ebx
    ret

count_stack_items:
    ;------------------------------------------
    ; int count_stack_items()
    ; Counts the number of items in the stack
    ; Returns the count
    ;------------------------------------------
    mov eax, [stack_top]               ; get stack top
    lea ebx, [stack]                   ; get stack base
    sub eax, ebx                       ; calculate size in bytes
    shr eax, 2                         ; convert to count
    ret

print_int:
    ;------------------------------------------
    ; void print_int(int value)
    ; Prints an integer
    ;------------------------------------------
    mov edi, digit_buffer + 10         ; end of buffer
    mov byte [edi], 0                  ; null-terminate
    dec edi
    xor ecx, ecx                       ; digit count
    test eax, eax                      ; check if zero
    jnz .convert
    mov byte [edi], '0'                ; handle zero
    inc ecx
    jmp .print
.convert:
    mov ebx, 10
.convert_loop:
    xor edx, edx                       ; clear remainder
    div ebx                            ; divide by 10
    add dl, '0'                        ; convert to ascii
    mov [edi], dl                      ; store digit
    dec edi
    inc ecx
    test eax, eax                      ; check quotient
    jnz .convert_loop
    inc edi                            ; adjust pointer
.print:
    mov edx, ecx                       ; length
    mov eax, 4                         ; sys_write
    mov ebx, 1
    mov ecx, edi                       ; address
    int 0x80
    ret

print_newline:
    ;------------------------------------------
    ; void print_newline()
    ; Prints a newline characte
    ;------------------------------------------
    mov eax, 4                         ; sys_write
    mov ebx, 1
    lea ecx, [linefeed]                ; newline address
    mov edx, 1                         ; length
    int 0x80
    ret
