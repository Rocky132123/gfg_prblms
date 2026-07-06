class Solution:
    def maxPathSum(self, a, b):
        # Code here
        i=j=0
        suma=sumb=0
        answer=0
        n=len(a)
        m=len(b)
        while i<n and j<m:
            if a[i]<b[j]:
                suma+=a[i]
                i+=1
            elif a[i]>b[j]:
                sumb+=b[j]
                j+=1
            else:
                answer+=max(suma,sumb)+a[i]
                suma=0
                sumb=0
                i+=1
                j+=1
        while i<n:
             suma+=a[i]
             i+=1 
        while j<m:
            sumb+=b[j]
            j+=1
            
                
        answer+=max(suma,sumb)
        return answer
                
                
                