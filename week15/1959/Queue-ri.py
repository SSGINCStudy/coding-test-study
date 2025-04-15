import sys
input = sys.stdin.readline

def solution():
    m, n = map(int, input().split())
    
    # 가로(m), 세로(n) 중 더 짧은 값을 기준으로 연산
    print(n*2-1 if m > n else m*2-2)
    
    # 좌표 연산
    if m == n: # 1:1 비율
        print(' '.join(map(str,(m//2+1, n//2+1) if m & 1 else (m//2+1, n//2))))
    elif m > n: # 아래로 길쭉
        print(' '.join(map(str,(n//2+1+(m-n), n//2+1) if n & 1 else (n//2+1, n//2))))
    else: # 옆으로 길쭉
        print(' '.join(map(str,(m//2+1, m//2+1+(n-m)) if m & 1 else (m//2+1, m//2))))
    

if __name__ == '__main__':
    solution()