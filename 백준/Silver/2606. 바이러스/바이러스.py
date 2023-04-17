n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
visited=[0]*(n+1) 
for i in range(m): 
    a,b=map(int,input().split())
    graph[a]+=[b] 
    graph[b]+=[a] 
    
def dfs(num):
    visited[num]=1
    for nx in graph[num]:
        if visited[nx]==0:
            dfs(nx)
dfs(1)
print(sum(visited)-1)